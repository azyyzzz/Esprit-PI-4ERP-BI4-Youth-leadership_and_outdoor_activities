import requests
import random
import argparse
import time

API_BASE = "http://localhost:8005"


def normal_payload():
    return {
        "Nb_Membres": random.uniform(10, 50),
        "Nb_Chefs": random.uniform(2, 8),
        "Participation_Rate": random.uniform(0.40, 0.90),
    }


def run():
    for _ in range(30):
        requests.post(f"{API_BASE}/predict", json=normal_payload(), timeout=5)
        time.sleep(0.1)
    print("Simulation done. Check Grafana/Prometheus metrics.")


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.parse_args()
    run()
