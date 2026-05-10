@echo off
REM Sends traffic to /predict so Grafana dashboards get Prometheus series
REM Requires: python mlops_api.py running on port 8005
cd /d "%~dp0"
python simulate_scenarios.py %*
pause
