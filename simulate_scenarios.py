"""
simulate_scenarios.py — Mandatory simulation scenarios for S13.

Runs 4 scenarios against the running FastAPI API:
  1. High Traffic     -> blast concurrent requests -> observe latency spikes
  2. API Errors       -> send malformed payloads -> observe error rate
  3. Model Drift      -> send out-of-distribution data -> observe drift score
  4. Accuracy Degrade -> trigger accuracy drop -> observe degradation alert

Usage:
  python simulate_scenarios.py              # run all scenarios
  python simulate_scenarios.py --scenario 1 # run specific scenario
"""

import argparse
import json
import time
import random
import concurrent.futures
import requests

API_BASE = "http://localhost:8005"
PREDICT_URL = f"{API_BASE}/predict"
HEALTH_URL = f"{API_BASE}/health"
DRIFT_URL = f"{API_BASE}/drift"
ALERTS_URL = f"{API_BASE}/alerts"
METRICS_URL = f"{API_BASE}/metrics"
DEGRADE_URL = f"{API_BASE}/simulate/degrade_accuracy"
RESTORE_URL = f"{API_BASE}/simulate/restore_accuracy"

SEPARATOR = "=" * 70


def normal_payload():
    """Generate a normal (in-distribution) prediction payload."""
    return {
        "Nb_Membres": random.uniform(10, 50),
        "Nb_Chefs": random.uniform(2, 8),
        "Participation_Rate": random.uniform(0.40, 0.90),
    }


def drifted_payload():
    """Generate an out-of-distribution payload (extreme values)."""
    return {
        "Nb_Membres": random.uniform(200, 500),       # way above training max of ~80
        "Nb_Chefs": random.uniform(50, 100),           # way above training max of ~15
        "Participation_Rate": random.uniform(0.01, 0.05),  # way below training mean of 0.65
    }


def malformed_payload():
    """Generate invalid payloads that should cause errors."""
    choices = [
        {},                                          # empty
        {"Nb_Membres": "invalid"},                   # wrong type
        {"Nb_Membres": 10},                          # missing fields
        {"Nb_Membres": None, "Nb_Chefs": None, "Participation_Rate": None},
    ]
    return random.choice(choices)


def send_predict(payload):
    """Send a prediction request and return (status_code, latency_ms)."""
    try:
        start = time.time()
        r = requests.post(PREDICT_URL, json=payload, timeout=10)
        latency = (time.time() - start) * 1000
        return r.status_code, latency
    except Exception as e:
        return 0, 0


def print_metrics_snapshot():
    """Print a snapshot of key metrics."""
    try:
        r = requests.get(DRIFT_URL, timeout=5)
        drift = r.json()
        print(f"  Drift Score:    {drift.get('drift_score', 'N/A')}")
        print(f"  Accuracy:       {drift.get('accuracy', 'N/A')}")
        print(f"  Confidence:     {drift.get('avg_confidence', 'N/A')}")
        print(f"  Is Drifted:     {drift.get('is_drifted', 'N/A')}")
        print(f"  Needs Retrain:  {drift.get('needs_retraining', 'N/A')}")
    except:
        print("  (Could not fetch drift data)")
    
    try:
        r = requests.get(ALERTS_URL, timeout=5)
        alerts = r.json()
        print(f"  Active Alerts:  {alerts.get('active_count', 0)}")
        for a in alerts.get("alerts", []):
            print(f"    [WARN] [{a['severity']}] {a['name']}: {a['message']}")
    except:
        print("  (Could not fetch alerts)")


# --------------------------------------------------------------------------
# Scenario 1: High Traffic
# --------------------------------------------------------------------------
def scenario_high_traffic():
    print(f"\n{SEPARATOR}")
    print("SCENARIO 1: HIGH TRAFFIC SIMULATION")
    print(f"{SEPARATOR}")
    print("Sending 50 concurrent requests to observe latency impact...\n")

    latencies = []
    errors = 0

    # Phase 1: Normal baseline (20 sequential requests)
    print("Phase 1: Baseline (20 sequential requests)")
    for i in range(20):
        code, lat = send_predict(normal_payload())
        latencies.append(lat)
        if code != 200:
            errors += 1
    
    baseline_avg = sum(latencies) / len(latencies)
    print(f"  Baseline avg latency: {baseline_avg:.1f}ms\n")

    # Phase 2: Burst traffic (50 concurrent requests)
    print("Phase 2: Burst (50 concurrent requests)")
    burst_latencies = []
    with concurrent.futures.ThreadPoolExecutor(max_workers=10) as executor:
        futures = [executor.submit(send_predict, normal_payload()) for _ in range(50)]
        for f in concurrent.futures.as_completed(futures):
            code, lat = f.result()
            if lat > 0:
                burst_latencies.append(lat)
            if code != 200:
                errors += 1

    if not burst_latencies:
        print("  [ERROR] No successful requests in burst phase.")
        return

    burst_avg = sum(burst_latencies) / len(burst_latencies)
    burst_p95 = sorted(burst_latencies)[int(len(burst_latencies) * 0.95)]
    
    print(f"  Burst avg latency:  {burst_avg:.1f}ms")
    print(f"  Burst P95 latency:  {burst_p95:.1f}ms")
    print(f"  Latency increase:   {(burst_avg / baseline_avg - 1) * 100:.1f}%")
    print(f"  Total errors:       {errors}")

    # Wait for Prometheus to scrape
    print("\n[WAIT] Waiting 15s for Prometheus to scrape metrics...")
    time.sleep(15)
    print("\n[METRICS] Current metrics:")
    print_metrics_snapshot()
    print(f"\n[OK] Scenario 1 complete!")


# --------------------------------------------------------------------------
# Scenario 2: API Errors
# --------------------------------------------------------------------------
def scenario_api_errors():
    print(f"\n{SEPARATOR}")
    print("SCENARIO 2: API ERROR SIMULATION")
    print(f"{SEPARATOR}")
    print("Sending 50 malformed requests to spike error rate...\n")

    success = 0
    fail = 0

    # Send 30 normal first (baseline)
    print("Phase 1: 30 normal requests (baseline)")
    for _ in range(30):
        code, _ = send_predict(normal_payload())
        if code == 200:
            success += 1
        else:
            fail += 1
    print(f"  Normal: {success} ok, {fail} errors")

    # Send 50 malformed
    print("\nPhase 2: 50 malformed requests (error injection)")
    error_count = 0
    for _ in range(50):
        payload = malformed_payload()
        try:
            r = requests.post(PREDICT_URL, json=payload, timeout=5)
            if r.status_code != 200:
                error_count += 1
        except:
            error_count += 1
    
    print(f"  Errors triggered: {error_count}/50")
    print(f"  Expected error rate spike: ~{error_count / 80 * 100:.1f}%")

    # Wait for scrape
    print("\n[WAIT] Waiting 15s for Prometheus to scrape metrics...")
    time.sleep(15)
    print("\n[METRICS] Current metrics:")
    print_metrics_snapshot()
    print(f"\n[OK] Scenario 2 complete!")


# --------------------------------------------------------------------------
# Scenario 3: Model Drift
# --------------------------------------------------------------------------
def scenario_model_drift():
    print(f"\n{SEPARATOR}")
    print("SCENARIO 3: MODEL DRIFT SIMULATION")
    print(f"{SEPARATOR}")
    print("Sending 80 out-of-distribution requests to trigger drift...\n")

    # Phase 1: Normal requests to establish baseline
    print("Phase 1: 20 normal requests (baseline)")
    for _ in range(20):
        send_predict(normal_payload())
    
    print("  [OK] Baseline established")
    print("\n[METRICS] Pre-drift metrics:")
    print_metrics_snapshot()

    # Phase 2: OOD requests
    print("\nPhase 2: 80 out-of-distribution requests (drift injection)")
    for i in range(80):
        send_predict(drifted_payload())
        if (i + 1) % 20 == 0:
            print(f"  Sent {i + 1}/80 drifted requests...")

    # Wait for scrape
    print("\n[WAIT] Waiting 15s for Prometheus to scrape metrics...")
    time.sleep(15)
    print("\n[METRICS] Post-drift metrics:")
    print_metrics_snapshot()
    print(f"\n[OK] Scenario 3 complete!")


# --------------------------------------------------------------------------
# Scenario 4: Performance Degradation
# --------------------------------------------------------------------------
def scenario_degradation():
    print(f"\n{SEPARATOR}")
    print("SCENARIO 4: PERFORMANCE DEGRADATION SIMULATION")
    print(f"{SEPARATOR}")
    print("Simulating accuracy drop below baseline...\n")

    # Phase 1: Check current state
    print("Phase 1: Current state")
    print_metrics_snapshot()

    # Phase 2: Trigger degradation
    print("\nPhase 2: Triggering accuracy degradation...")
    try:
        r = requests.post(DEGRADE_URL, timeout=5)
        result = r.json()
        print(f"  [OK] {result.get('message', 'Degraded')}")
    except Exception as e:
        print(f"  [FAIL] Failed: {e}")

    # Send some requests to trigger alerting evaluation
    print("\nPhase 3: Sending 20 requests to evaluate alerts...")
    for _ in range(20):
        send_predict(normal_payload())

    print("\n[WAIT] Waiting 15s for Prometheus to scrape metrics...")
    time.sleep(15)
    print("\n[METRICS] Post-degradation metrics:")
    print_metrics_snapshot()

    # Phase 4: Restore
    print("\nPhase 4: Restoring accuracy to baseline...")
    try:
        r = requests.post(RESTORE_URL, timeout=5)
        result = r.json()
        print(f"  [OK] {result.get('message', 'Restored')}")
    except Exception as e:
        print(f"  [FAIL] Failed: {e}")

    # Send requests to clear alert
    for _ in range(20):
        send_predict(normal_payload())

    print("\n[METRICS] Post-restore metrics:")
    print_metrics_snapshot()
    print(f"\n[OK] Scenario 4 complete!")


# --------------------------------------------------------------------------
# Main
# --------------------------------------------------------------------------
def check_api_health():
    """Verify the API is running before starting scenarios."""
    print("Checking API health...")
    try:
        r = requests.get(HEALTH_URL, timeout=5)
        if r.status_code == 200:
            print(f"  [OK] API is healthy: {r.json()}\n")
            return True
        else:
            print(f"  [FAIL] API returned {r.status_code}: {r.text}")
            return False
    except Exception as e:
        print(f"  [FAIL] Cannot reach API at {API_BASE}: {e}")
        print("  → Make sure the API is running: python mlops_api.py")
        return False


def main():
    parser = argparse.ArgumentParser(description="Scouts MLOps Simulation Scenarios")
    parser.add_argument("--scenario", type=int, choices=[1, 2, 3, 4],
                        help="Run a specific scenario (1-4). Default: run all.")
    args = parser.parse_args()

    print(f"\n{'=' * 70}")
    print("   SCOUTS MLOps - PRODUCTION MONITORING SIMULATION")
    print(f"{'=' * 70}\n")

    if not check_api_health():
        return

    scenarios = {
        1: ("High Traffic", scenario_high_traffic),
        2: ("API Errors", scenario_api_errors),
        3: ("Model Drift", scenario_model_drift),
        4: ("Performance Degradation", scenario_degradation),
    }

    if args.scenario:
        name, func = scenarios[args.scenario]
        print(f"Running scenario {args.scenario}: {name}")
        func()
    else:
        print("Running ALL 4 scenarios sequentially...\n")
        for num, (name, func) in scenarios.items():
            func()
            if num < 4:
                print(f"\n{'----------------------------------------------------------------------'}")
                print("Pausing 5s before next scenario...\n")
                time.sleep(5)

    print(f"\n{'=' * 70}")
    print("   ALL SCENARIOS COMPLETE")
    print(f"{'=' * 70}")
    print("\nCheck Grafana dashboard at: http://localhost:3000")
    print("   (login: admin / admin)")
    print("Check logs at: logs/monitoring.log")
    print("Check alerts at: logs/monitoring_alerts.log\n")


if __name__ == "__main__":
    main()
