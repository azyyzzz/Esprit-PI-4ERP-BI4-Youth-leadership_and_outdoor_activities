import os
target = r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\templates\index.html"
css = """<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>Scout Group DSS - ML Intelligence</title>
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet"/>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet"/>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
:root{--green-dark:#1e4d2b;--green-mid:#2d6a3f;--green-light:#3d8b50;--gold:#b5860d;--gold-light:#d4a017;--gold-card:#7a5010;--beige:#f5f0e6;--beige2:#eae3d0;--beige3:#ddd3b8;--cream:#faf7f0;--red:#c0392b;--red-light:#e74c3c;--amber:#d4730a;--text-dark:#1a1a1a;--text-mid:#4a4a4a;--text-light:#777;--white:#fff}
*{margin:0;padding:0;box-sizing:border-box;font-family:'Inter',sans-serif}
body{background:var(--beige);color:var(--text-dark);height:100vh;display:flex;flex-direction:column;overflow:hidden}
.app-container{display:flex;flex:1;overflow:hidden}
header{background:var(--green-dark);color:var(--white);padding:12px 30px;display:flex;justify-content:space-between;align-items:center;border-bottom:4px solid var(--gold);z-index:100;box-shadow:0 4px 15px rgba(0,0,0,.2)}
.brand{display:flex;align-items:center;gap:15px}
.brand-logo{width:45px;height:45px;background:var(--gold);border-radius:50%;display:flex;align-items:center;justify-content:center;font-size:24px;border:2px solid white;box-shadow:0 0 15px rgba(181,134,13,.4)}
.brand-text h1{font-size:19px;font-weight:800;letter-spacing:-.5px}
.brand-text p{font-size:11px;opacity:.8;font-weight:500;margin-top:-2px}
.top-actions{display:flex;align-items:center;gap:20px}
.badge-status{background:rgba(255,255,255,.1);border:1px solid rgba(255,255,255,.2);padding:6px 14px;border-radius:20px;font-size:11px;font-weight:700;display:flex;align-items:center;gap:8px}
.status-dot{width:8px;height:8px;background:#00ff88;border-radius:50%;box-shadow:0 0 10px #00ff88}
aside.sidebar{width:280px;background:var(--green-dark);display:flex;flex-direction:column;border-right:2px solid var(--gold);overflow-y:auto}
.sidebar-nav{padding:15px 0}
.nav-category{padding:15px 25px 8px;font-size:10px;font-weight:800;color:var(--gold-light);text-transform:uppercase;letter-spacing:1.2px;opacity:.9}
.nav-item{padding:12px 25px;display:flex;align-items:center;justify-content:space-between;cursor:pointer;transition:.3s;color:var(--white);border-left:4px solid transparent}
.nav-item:hover{background:rgba(255,255,255,.08);border-left-color:var(--gold-light)}
.nav-item.active{background:rgba(255,255,255,.12);border-left:4px solid var(--gold);color:var(--white);font-weight:700}
.nav-link{display:flex;align-items:center;gap:15px;font-size:13.5px}
.nav-link i{width:20px;font-size:16px;opacity:.9}
.nav-item.active .nav-link i{color:var(--gold);opacity:1}
.obj-tag{font-size:9px;padding:2px 6px;border-radius:4px;background:rgba(255,255,255,.15);font-weight:800;opacity:.7;color:var(--white)}
.nav-item.active .obj-tag{background:var(--gold);opacity:1;color:var(--white)}
main.content{flex:1;padding:30px;overflow-y:auto;background:var(--beige)}
.dashboard-header{background:white;padding:25px;border-radius:15px;border-left:8px solid var(--gold);margin-bottom:30px;box-shadow:0 4px 20px rgba(0,0,0,.05);display:flex;justify-content:space-between;align-items:center}
.dashboard-header h2{font-size:24px;font-weight:800;color:var(--green-dark);display:flex;align-items:center;gap:12px}
.kpi-grid{display:grid;grid-template-columns:repeat(4,1fr);gap:20px;margin-bottom:30px}
.kpi-card{padding:20px;border-radius:15px;color:white;display:flex;flex-direction:column;justify-content:space-between;min-height:120px;position:relative;overflow:hidden;box-shadow:0 8px 25px rgba(0,0,0,.1)}
.kpi-card i.bg-icon{position:absolute;right:-10px;bottom:-10px;font-size:80px;opacity:.15;transform:rotate(-15deg)}
.kpi-card.green{background:var(--green-mid);border-bottom:5px solid var(--green-dark)}
.kpi-card.gold{background:var(--gold);border-bottom:5px solid var(--gold-card)}
.kpi-card.orange{background:var(--amber);border-bottom:5px solid #a35a07}
.kpi-card.red{background:var(--red);border-bottom:5px solid var(--red-light)}
.kpi-label{font-size:11px;font-weight:800;text-transform:uppercase;letter-spacing:.5px;margin-bottom:5px;opacity:.9}
.kpi-value{font-size:32px;font-weight:800;letter-spacing:-1px}
.kpi-sub{font-size:12px;opacity:.8;margin-top:5px}
.chart-container{background:white;padding:30px;border-radius:20px;box-shadow:0 10px 40px rgba(0,0,0,.04);border:1px solid rgba(0,0,0,.05)}
.chart-header{display:flex;justify-content:space-between;align-items:center;margin-bottom:25px}
.chart-header h3{font-size:18px;color:var(--green-dark);font-weight:800;border-left:4px solid var(--gold);padding-left:15px}
.insight-card{background:linear-gradient(135deg,#fff,#f9f9f9);padding:30px;border-radius:20px;border:1px solid rgba(0,0,0,.05);text-align:center;height:100%;display:flex;flex-direction:column;justify-content:center;align-items:center}
.insight-icon{font-size:50px;color:var(--green-dark);margin-bottom:20px}
.insight-text h4{font-size:20px;font-weight:800;color:var(--green-dark);margin-bottom:10px}
.insight-text p{font-size:14px;color:var(--text-mid);line-height:1.6;max-width:250px;margin:0 auto 20px}
.strategy-btn{background:var(--green-dark);color:white;padding:12px 25px;border-radius:10px;font-weight:700;font-size:13px;text-transform:uppercase;border:none;cursor:pointer;transition:.3s}
.strategy-btn:hover{background:var(--gold);transform:scale(1.05)}
.btn-refresh{background:var(--green-dark);color:white;border:none;padding:10px 20px;border-radius:8px;cursor:pointer;font-weight:700;font-size:12px;display:flex;align-items:center;gap:10px}
.btn-refresh:hover{background:var(--gold)}
.sidebar-header{padding:25px;text-align:center;border-bottom:1px solid rgba(255,255,255,.1)}
.arabic-title{color:var(--white);font-size:14px;font-weight:700;margin-top:10px;line-height:1.4;opacity:.9}
.modal-overlay{position:fixed;top:0;left:0;width:100%;height:100%;background:rgba(0,0,0,.7);z-index:9999;display:flex;justify-content:center;align-items:center;backdrop-filter:blur(5px)}
.modal-box{background:white;border-radius:20px;padding:40px;width:420px;box-shadow:0 25px 60px rgba(0,0,0,.3);text-align:center;border-top:6px solid var(--gold)}
.modal-box h2{color:var(--green-dark);font-size:22px;font-weight:800;margin:15px 0 10px}
.modal-box p{color:var(--text-mid);font-size:13px;margin-bottom:20px}
.modal-box select,.modal-box input{width:100%;padding:12px;border:2px solid var(--beige3);border-radius:10px;font-size:14px;margin-bottom:15px;font-weight:600}
.modal-box button{width:100%;padding:14px;background:var(--green-dark);color:white;border:none;border-radius:10px;font-size:15px;font-weight:800;cursor:pointer;transition:.3s}
.modal-box button:hover{background:var(--gold)}
.hidden{display:none!important}
table{width:100%;border-collapse:collapse;margin-top:15px}
table th{background:var(--green-dark);color:white;padding:12px 15px;text-align:left;border-bottom:3px solid var(--gold);font-size:12px;font-weight:800;text-transform:uppercase}
table td{padding:12px 15px;border-bottom:1px solid var(--beige2);font-size:13px}
table tr:hover{background:var(--beige2)}
.alert-card{padding:15px;border-radius:10px;margin-bottom:10px;border-left:5px solid}
.alert-card.high{background:#ffeaea;border-color:var(--red)}
.alert-card.medium{background:#fff5e6;border-color:var(--amber)}
.weather-input{display:grid;grid-template-columns:1fr 1fr 1fr;gap:15px;margin:20px 0}
.weather-input input{padding:12px;border:2px solid var(--beige3);border-radius:10px;font-size:14px;font-weight:600}
</style>
</head>
<body>
"""
with open(target,'w',encoding='utf-8') as f:
    f.write(css)
print("Part 1 done: CSS written")
