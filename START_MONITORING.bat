@echo off
cd /d "%~dp0"
docker compose up -d prometheus grafana
echo Grafana: http://localhost:3000 (admin/admin)
echo Prometheus: http://localhost:9090
pause
