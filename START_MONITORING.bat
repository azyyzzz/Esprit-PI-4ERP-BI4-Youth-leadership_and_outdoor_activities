@echo off
REM Prometheus (9090) + Grafana (3000) — scrape config uses host.docker.internal:8005
REM Run START_MLOPS_API.bat in another window first (or docker compose fastapi_model).
cd /d "%~dp0"
docker compose up -d prometheus grafana
echo If Grafana iframe in DSS still fails, apply embedding env vars:
echo   docker compose up -d --force-recreate grafana
echo.
echo Grafana:  http://localhost:3000  (admin/admin)
echo Prometheus targets: http://localhost:9090/targets
echo Then run RUN_SIMULATION.bat while MLOps API is on :8005
pause
