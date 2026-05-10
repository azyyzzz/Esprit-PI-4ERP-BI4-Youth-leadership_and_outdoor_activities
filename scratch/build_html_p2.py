target = r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\templates\index.html"
html_body = """
<div id="login-modal" class="modal-overlay">
  <div class="modal-box">
    <i class="fa fa-shield-halved" style="font-size:40px;color:var(--gold)"></i>
    <h2>Scout Group DSS</h2>
    <p>Industrial Decision Support System</p>
    <select id="role-select" onchange="onRoleChange()">
      <option value="">-- Select Role --</option>
      <option value="admin">Admin (Full Access)</option>
      <option value="regional">Regional Leader</option>
      <option value="unit">Unit Leader</option>
    </select>
    <div id="unit-select-container" class="hidden">
      <select id="sub-role-select">
        <option value="ASFR">ASFR (Al-Asafir)</option>
        <option value="CHBL">CHBL (Achbal)</option>
        <option value="ZHRT">ZHRT (Zahrat)</option>
        <option value="KRSH">KRSH (Kashshaf)</option>
        <option value="JWLA">JWLA (Jawwala)</option>
        <option value="QDMA">QDMA (Qudamaa)</option>
        <option value="MNWR">MNWR (Munawar)</option>
      </select>
    </div>
    <input type="text" id="login-user" placeholder="Username (admin)" value="admin"/>
    <input type="password" id="login-pass" placeholder="Password (scout2026)" value="scout2026"/>
    <button onclick="confirmLogin()">Sign In</button>
    <p style="margin-top:15px;font-size:11px;color:#999">Default: admin / scout2026</p>
  </div>
</div>

<header>
  <div class="brand">
    <div class="brand-logo">&#9878;</div>
    <div class="brand-text">
      <h1>Scout Group DSS - ML Intelligence Hub</h1>
      <p>Industrial Decision Support System for Scouts Tunisia</p>
    </div>
  </div>
  <div class="top-actions">
    <div class="badge-status"><div class="status-dot"></div><span id="data-source-label">SCOUT DW CONNECTED</span></div>
    <button class="btn-refresh" onclick="location.reload()"><i class="fas fa-sync-alt"></i> REFRESH</button>
    <button class="btn-refresh" onclick="logout()" style="background:var(--red)"><i class="fas fa-sign-out-alt"></i> LOGOUT</button>
  </div>
</header>

<div class="app-container">
  <aside class="sidebar">
    <div class="sidebar-header">
      <i class="fas fa-microchip" style="font-size:40px;color:var(--gold)"></i>
      <div class="arabic-title">&#1606;&#1592;&#1575;&#1605; &#1583;&#1593;&#1605; &#1575;&#1604;&#1602;&#1585;&#1575;&#1585; &#1604;&#1604;&#1603;&#1588;&#1575;&#1601;&#1577; &#1575;&#1604;&#1578;&#1608;&#1606;&#1587;&#1610;&#1577;</div>
    </div>
    <div class="sidebar-nav">
      <div class="nav-category">Predictive Analytics</div>
      <div class="nav-item" onclick="loadObj(1,this)"><div class="nav-link"><i class="fas fa-users"></i> Membership Forecast</div><span class="obj-tag">REG</span></div>
      <div class="nav-item" onclick="loadObj(2,this)"><div class="nav-link"><i class="fas fa-chart-line"></i> Participation Prediction</div><span class="obj-tag">REG</span></div>
      <div class="nav-item" onclick="loadObj(3,this)"><div class="nav-link"><i class="fas fa-money-bill-wave"></i> Budget Estimation</div><span class="obj-tag">REG</span></div>
      <div class="nav-category">Classification & Risk</div>
      <div class="nav-item" onclick="loadObj(4,this)"><div class="nav-link"><i class="fas fa-exclamation-triangle"></i> Anomaly Detection</div><span class="obj-tag">ISO</span></div>
      <div class="nav-item" onclick="loadObj(5,this)"><div class="nav-link"><i class="fas fa-tachometer-alt"></i> Unit Performance</div><span class="obj-tag">CLF</span></div>
      <div class="nav-item" onclick="loadObj(6,this)"><div class="nav-link"><i class="fas fa-shield-virus"></i> At-Risk Units</div><span class="obj-tag">CLF</span></div>
      <div class="nav-category">Clustering & Scoring</div>
      <div class="nav-item" onclick="loadObj(7,this)"><div class="nav-link"><i class="fas fa-project-diagram"></i> Behavioral Segmentation</div><span class="obj-tag">KM</span></div>
      <div class="nav-item" onclick="loadObj(8,this)"><div class="nav-link"><i class="fas fa-star"></i> Engagement Scoring</div><span class="obj-tag">SCR</span></div>
      <div class="nav-category">Weather & Operations</div>
      <div class="nav-item" onclick="loadObj(9,this)"><div class="nav-link"><i class="fas fa-cloud-sun"></i> Weather Impact</div><span class="obj-tag">CLF</span></div>
      <div class="nav-item" onclick="loadObj(10,this)"><div class="nav-link"><i class="fas fa-campground"></i> Activity Adaptation</div><span class="obj-tag">SIM</span></div>
      <div class="nav-category">Decision Support</div>
      <div class="nav-item" onclick="loadObj(11,this)"><div class="nav-link"><i class="fas fa-bell"></i> Early Warning System</div><span class="obj-tag">EWS</span></div>
      <div class="nav-item" onclick="loadObj(12,this)"><div class="nav-link"><i class="fas fa-calculator"></i> Scenario Analysis</div><span class="obj-tag">WIF</span></div>
      <div class="nav-category">MLOps Integration</div>
      <div class="nav-item" onclick="loadObj(13,this)"><div class="nav-link"><i class="fas fa-rocket"></i> MLOps API Test</div><span class="obj-tag">API</span></div>
      <div class="nav-item active" onclick="loadObj(14,this)"><div class="nav-link"><i class="fas fa-chess-knight"></i> Strategic BI</div><span class="obj-tag">PBI</span></div>
      <div class="nav-item" onclick="loadObj(15,this)"><div class="nav-link"><i class="fas fa-chart-area"></i> Grafana Portal</div><span class="obj-tag">MON</span></div>
    </div>
  </aside>
  <main class="content"><div id="render-area"></div></main>
</div>
"""
with open(target,'a',encoding='utf-8') as f:
    f.write(html_body)
print("Part 2 done: HTML body written")
