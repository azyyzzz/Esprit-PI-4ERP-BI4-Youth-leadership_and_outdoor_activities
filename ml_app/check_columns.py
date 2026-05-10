import pyodbc

available = [d for d in pyodbc.drivers() if 'SQL Server' in d]
driver = next((d for d in available if '17' in d), None) or available[0]
conn_str = f'DRIVER={{{driver}}};SERVER=localhost;DATABASE=scouts_DW;Trusted_Connection=yes;TrustServerCertificate=yes;Encrypt=yes'
conn = pyodbc.connect(conn_str)
cursor = conn.cursor()

print("=" * 80)
print("COLUMNS IN dim_membre:")
print("=" * 80)

try:
    # Get all columns in dim_membre
    cursor.execute("""
        SELECT COLUMN_NAME, DATA_TYPE, IS_NULLABLE
        FROM INFORMATION_SCHEMA.COLUMNS
        WHERE TABLE_NAME = 'dim_membre'
        ORDER BY ORDINAL_POSITION
    """)
    
    for col_name, data_type, is_nullable in cursor.fetchall():
        print(f"  {col_name:20} | {data_type:15} | Nullable: {is_nullable}")
        
except Exception as e:
    print(f"ERROR: {e}")

print("\n" + "=" * 80)
print("SAMPLE DATA FROM dim_membre (TOP 3 ROWS):")
print("=" * 80)

try:
    cursor.execute("SELECT TOP 3 * FROM dbo.dim_membre")
    columns = [description[0] for description in cursor.description]
    print(f"Columns: {columns}\n")
    
    for row in cursor.fetchall():
        print(dict(zip(columns, row)))
        
except Exception as e:
    print(f"ERROR: {e}")

conn.close()
