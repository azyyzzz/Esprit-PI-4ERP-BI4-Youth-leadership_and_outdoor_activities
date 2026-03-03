# Script PowerShell pour voir les logs Airflow
# Usage: .\logs.ps1 [service]
# Services disponibles: webserver, scheduler, postgres, all

param(
    [string]$Service = "all"
)

Write-Host "📋 Affichage des logs..." -ForegroundColor Cyan
Write-Host ""

switch ($Service.ToLower()) {
    "webserver" {
        Write-Host "Logs Airflow Webserver:" -ForegroundColor Green
        docker-compose logs -f airflow-webserver
    }
    "scheduler" {
        Write-Host "Logs Airflow Scheduler:" -ForegroundColor Green
        docker-compose logs -f airflow-scheduler
    }
    "postgres" {
        Write-Host "Logs PostgreSQL:" -ForegroundColor Green
        docker-compose logs -f postgres
    }
    default {
        Write-Host "Logs de tous les services:" -ForegroundColor Green
        docker-compose logs -f
    }
}
