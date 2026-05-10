@echo off
REM Scouts DSS — avoids Windows port 5000 bind failures (use 8765 by default)
cd /d "%~dp0ml_app"
set FLASK_RUN_PORT=8765
echo.
echo ========================================
echo   Scouts DSS  —  http://127.0.0.1:%FLASK_RUN_PORT%/
echo ========================================
echo.
python app.py
if errorlevel 1 pause
