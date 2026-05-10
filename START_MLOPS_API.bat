@echo off
REM FastAPI metrics for Prometheus/Grafana (port 8005)
cd /d "%~dp0"
echo Starting MLOps API on http://127.0.0.1:8005 ...
python mlops_api.py
pause
