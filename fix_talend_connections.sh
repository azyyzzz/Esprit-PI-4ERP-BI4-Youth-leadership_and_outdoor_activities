#!/bin/bash
# Script pour remplacer localhost par host.docker.internal dans tous les fichiers Talend

echo "🔧 Modification des fichiers de connexion Talend..."

# Trouver tous les fichiers .item dans les dossiers de connexion
find /opt/airflow/talend -path "*/metadata/connections/*.item" -type f | while read file; do
    echo "  Modification: $file"
    # Remplacer localhost par host.docker.internal
    sed -i 's/localhost/host.docker.internal/g' "$file"
done

echo "✅ Terminé! Tous les fichiers ont été modifiés."
echo ""
echo "Vérification d'un fichier modifié:"
grep -n "host.docker.internal" /opt/airflow/talend/DIM_master/Scout_DW_RUN_methode2_0.1/Scout_DW_RUN_methode2/items/projet_pi_bi/metadata/connections/scout_DW_0.1.item | head -3
