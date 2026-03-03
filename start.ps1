# Script PowerShell pour démarrer Airflow + Talend
# Usage: .\start.ps1

Write-Host "🚀 Démarrage d'Airflow avec les jobs Talend..." -ForegroundColor Green
Write-Host ""

# Vérifier si Docker est en cours d'exécution
$dockerRunning = docker info 2>&1 | Select-String "Server Version"
if (-not $dockerRunning) {
    Write-Host "❌ Docker n'est pas en cours d'exécution." -ForegroundColor Red
    Write-Host "   Veuillez démarrer Docker Desktop et réessayer." -ForegroundColor Yellow
    exit 1
}

Write-Host "✓ Docker est en cours d'exécution" -ForegroundColor Green

# Construire et démarrer les conteneurs
Write-Host ""
Write-Host "📦 Construction et démarrage des conteneurs..." -ForegroundColor Cyan
docker-compose up -d --build

if ($LASTEXITCODE -eq 0) {
    Write-Host ""
    Write-Host "✅ Airflow est démarré avec succès!" -ForegroundColor Green
    Write-Host ""
    Write-Host "📊 Accès à l'interface web:" -ForegroundColor Cyan
    Write-Host "   URL:      http://localhost:8080" -ForegroundColor White
    Write-Host "   Username: admin" -ForegroundColor White
    Write-Host "   Password: admin" -ForegroundColor White
    Write-Host ""
    Write-Host "⏳ Patientez 30-60 secondes pour que tous les services démarrent..." -ForegroundColor Yellow
    Write-Host ""
    Write-Host "📝 Pour voir les logs:" -ForegroundColor Cyan
    Write-Host "   docker-compose logs -f" -ForegroundColor White
    Write-Host ""
    Write-Host "🛑 Pour arrêter:" -ForegroundColor Cyan
    Write-Host "   docker-compose down" -ForegroundColor White
    Write-Host ""
} else {
    Write-Host ""
    Write-Host "❌ Erreur lors du démarrage" -ForegroundColor Red
    Write-Host "   Vérifiez les logs avec: docker-compose logs" -ForegroundColor Yellow
    exit 1
}
