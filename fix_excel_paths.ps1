# Script pour remplacer les chemins Excel Windows par des chemins Linux
Write-Host "Modification des chemins Excel dans les fichiers Talend..." -ForegroundColor Cyan

$files = Get-ChildItem -Path "talend\SA_master" -Recurse -Filter "*.item"
$count = 0

foreach ($file in $files) {
    $content = Get-Content $file.FullName -Raw -Encoding UTF8
    
    if ($content -match 'C:/Projet_PI_BI') {
        $newContent = $content -replace 'C:/Projet_PI_BI', '/opt/airflow/projet_pi_bi'
        Set-Content -Path $file.FullName -Value $newContent -Encoding UTF8 -NoNewline
        $count++
        Write-Host "  OK: $($file.Name)" -ForegroundColor Green
    }
}

Write-Host ""
Write-Host "$count fichiers modifies!" -ForegroundColor Green
Write-Host "Les chemins C:/Projet_PI_BI ont ete remplaces par /opt/airflow/projet_pi_bi" -ForegroundColor Yellow
