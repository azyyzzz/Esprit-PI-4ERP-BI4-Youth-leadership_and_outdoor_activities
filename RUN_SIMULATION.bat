@echo off
cd /d "%~dp0"
python simulate_scenarios.py %*
pause
