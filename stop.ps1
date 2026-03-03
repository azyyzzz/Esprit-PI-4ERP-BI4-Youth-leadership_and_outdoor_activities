# Script PowerShell pour arrêter Airflow
# Usage: .\stop.ps1

Write-Host "🛑 Arrêt d'Airflow..." -ForegroundColor Yellow
Write-Host ""

docker-compose down

if ($LASTEXITCODE -eq 0) {
    Write-Host ""
    Write-Host "✅ Airflow a été arrêté avec succès!" -ForegroundColor Green
    Write-Host ""
} else {
    Write-Host ""
    Write-Host "❌ Erreur lors de l'arrêt" -ForegroundColor Red
    exit 1
}
