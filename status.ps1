# Script PowerShell pour vérifier l'état d'Airflow
# Usage: .\status.ps1

Write-Host "🔍 Vérification de l'état d'Airflow..." -ForegroundColor Cyan
Write-Host ""

# Vérifier si Docker est en cours d'exécution
$dockerRunning = docker info 2>&1 | Select-String "Server Version"
if (-not $dockerRunning) {
    Write-Host "❌ Docker n'est pas en cours d'exécution." -ForegroundColor Red
    Write-Host "   Airflow n'est donc pas démarré." -ForegroundColor Yellow
    exit 1
}

Write-Host "✓ Docker est en cours d'exécution" -ForegroundColor Green
Write-Host ""

# Lister les conteneurs
Write-Host "📦 État des conteneurs:" -ForegroundColor Cyan
docker-compose ps

Write-Host ""

# Vérifier si tous les services sont actifs
$containers = docker-compose ps --services --filter "status=running"
$totalServices = docker-compose ps --services

if ($containers.Count -eq $totalServices.Count) {
    Write-Host "✅ Tous les services sont actifs!" -ForegroundColor Green
    Write-Host ""
    Write-Host "🌐 Accéder à Airflow:" -ForegroundColor Cyan
    Write-Host "   http://localhost:8080" -ForegroundColor White
    Write-Host "   Username: admin" -ForegroundColor White
    Write-Host "   Password: admin" -ForegroundColor White
} else {
    Write-Host "⚠️  Certains services ne sont pas actifs" -ForegroundColor Yellow
    Write-Host "   Utilisez: docker-compose up -d" -ForegroundColor White
}

Write-Host ""
