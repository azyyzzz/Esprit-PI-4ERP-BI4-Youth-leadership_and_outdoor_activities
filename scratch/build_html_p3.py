target = r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\templates\index.html"
js = r"""
<script>
let currentRole='',currentUnit='',currentObj=14;
const registeredUsers=JSON.parse(localStorage.getItem('registeredUsers')||'{"admin":"scout2026"}');

function onRoleChange(){
  const v=document.getElementById('role-select').value;
  document.getElementById('unit-select-container').classList.toggle('hidden',v!=='unit'&&v!=='regional');
}

function confirmLogin(){
  const u=document.getElementById('login-user').value;
  const p=document.getElementById('login-pass').value;
  if(registeredUsers[u]&&registeredUsers[u]===p){
    currentRole=document.getElementById('role-select').value||'admin';
    currentUnit=document.getElementById('sub-role-select')?document.getElementById('sub-role-select').value:'';
    document.getElementById('login-modal').classList.add('hidden');
    loadObj(14,document.querySelector('.nav-item.active'));
  }else{alert('Invalid credentials. Use admin/scout2026');}
}

function logout(){
  currentRole='';currentUnit='';
  document.getElementById('login-modal').classList.remove('hidden');
}

function filterByUnit(list){
  if(!currentUnit||currentRole==='admin')return list;
  return list.filter(i=>(i.unit||'').toUpperCase().includes(currentUnit.toUpperCase()));
}

function loading(el){el.innerHTML='<div style="text-align:center;padding:60px"><i class="fas fa-spinner fa-spin fa-3x" style="color:var(--gold)"></i><p style="margin-top:15px;font-weight:700">Analyzing Scout Intelligence...</p></div>';}

async function loadObj(n,navEl){
  currentObj=n;
  document.querySelectorAll('.nav-item').forEach(x=>x.classList.remove('active'));
  if(navEl)navEl.classList.add('active');
  const el=document.getElementById('render-area');
  loading(el);

  if(n===14){showStrategicBI(el);return;}
  if(n===15){el.innerHTML='<div class="dashboard-header"><h2><i class="fas fa-chart-area"></i> Grafana Monitoring Portal</h2></div><div class="chart-container"><iframe src="http://localhost:3000" style="width:100%;height:calc(100vh - 250px);border:none;border-radius:12px" title="Grafana"></iframe></div>';return;}

  try{
    let url='/api/obj/'+n;
    const resp=await fetch(url);
    const data=await resp.json();
    let h='<div class="dashboard-header"><h2><i class="fas fa-microchip"></i> '+(data.objective||'Objective '+n)+'</h2><div style="font-size:12px;color:#777">Model: '+(data.model||'ML Engine')+' | RMSE: '+(data.rmse?data.rmse.toFixed(4):'N/A')+'</div></div>';

    if(n===1){
      const s=filterByUnit(data.sample||[]);
      h+='<div class="kpi-grid"><div class="kpi-card green"><div class="kpi-label">Units Analyzed</div><div class="kpi-value">'+s.length+'</div><i class="fas fa-users bg-icon"></i></div><div class="kpi-card gold"><div class="kpi-label">RMSE</div><div class="kpi-value">'+(data.rmse||0).toFixed(2)+'</div><i class="fas fa-bullseye bg-icon"></i></div></div>';
      h+=makeTable(['Unit','Current Members','Predicted Members'],s.map(r=>[r.unit,Math.round(r.current),Math.round(r.predicted)]));
    }
    else if(n===2){
      const s=filterByUnit(data.sample||[]);
      h+=makeTable(['Unit','Actual Rate','Predicted Rate'],s.map(r=>[r.unit,(r.actual*100).toFixed(1)+'%',(r.predicted*100).toFixed(1)+'%']));
    }
    else if(n===3){
      const s=filterByUnit(data.sample||[]);
      h+=makeTable(['Unit','Allocated (TND)','Consumed (TND)','Predicted (TND)'],s.map(r=>[r.unit,Math.round(r.allocated),Math.round(r.consumed),Math.round(r.predicted)]));
    }
    else if(n===4){
      const a=filterByUnit(data.anomalies||[]);
      h+='<div class="kpi-grid"><div class="kpi-card red"><div class="kpi-label">Anomalies Found</div><div class="kpi-value">'+a.length+'</div><i class="fas fa-exclamation-triangle bg-icon"></i></div></div>';
      h+=makeTable(['Unit','Allocated','Consumed','Ratio'],a.map(r=>[r.unit,Math.round(r.allocated),Math.round(r.consumed),r.ratio.toFixed(2)]));
    }
    else if(n===5){
      const s=filterByUnit(data.sample||[]);
      const d=data.distribution||{};
      h+='<div class="kpi-grid"><div class="kpi-card green"><div class="kpi-label">Elite</div><div class="kpi-value">'+(d.Elite||0)+'</div><i class="fas fa-trophy bg-icon"></i></div><div class="kpi-card gold"><div class="kpi-label">Standard</div><div class="kpi-value">'+(d.Standard||0)+'</div><i class="fas fa-check bg-icon"></i></div><div class="kpi-card orange"><div class="kpi-label">Emerging</div><div class="kpi-value">'+(d.Emerging||0)+'</div><i class="fas fa-seedling bg-icon"></i></div></div>';
      h+=makeTable(['Unit','Score','Rating'],s.map(r=>[r.unit,Math.round(r.score),r.rating]));
    }
    else if(n===6){
      const a=filterByUnit(data.at_risk_units||[]);
      h+='<div class="kpi-grid"><div class="kpi-card red"><div class="kpi-label">At-Risk Units</div><div class="kpi-value">'+(data.n_at_risk||0)+'</div><i class="fas fa-shield-virus bg-icon"></i></div></div>';
      h+=makeTable(['Unit','Members','Participation','Status'],a.map(r=>[r.unit,Math.round(r.members),(r.participation*100).toFixed(1)+'%','<span style="color:'+(r.class==="High Risk"?"var(--red)":"var(--green-dark)")+';font-weight:800">'+r.class+'</span>']));
    }
    else if(n===7){
      const c=data.clusters||[];
      h+=makeTable(['Cluster','Count','Avg Members','Avg Participation','Efficiency'],c.map(r=>[r.label,r.count,r.avg_members,(r.avg_participation*100).toFixed(0)+'%',r.efficiency]));
    }
    else if(n===8){
      const s=filterByUnit(data.scores||[]);
      h+=makeTable(['Unit','Score','Level'],s.map(r=>[r.unit,r.score.toFixed(1),'<span style="color:'+(r.level==="High"?"var(--green-dark)":r.level==="Medium"?"var(--amber)":"var(--red)")+';font-weight:800">'+r.level+'</span>']));
    }
    else if(n===9){
      h+='<div class="kpi-grid"><div class="kpi-card green"><div class="kpi-label">Model Accuracy</div><div class="kpi-value">'+(data.accuracy*100).toFixed(0)+'%</div><i class="fas fa-cloud-sun bg-icon"></i></div></div><div class="chart-container"><p style="font-size:15px;color:var(--text-mid);padding:20px">'+data.description+'</p></div>';
    }
    else if(n===10){
      h+='<div class="chart-container"><h3 style="margin-bottom:20px;color:var(--green-dark)">Weather Simulation</h3><div class="weather-input"><input id="w-temp" type="number" placeholder="Temperature (C)" value="28"/><input id="w-rain" type="number" placeholder="Rainfall (mm)" value="5"/><input id="w-wind" type="number" placeholder="Wind Speed (km/h)" value="15"/></div><button class="strategy-btn" onclick="runWeather()" style="width:100%">RUN SIMULATION</button><div id="weather-result" style="margin-top:20px;padding:20px;border-radius:10px;text-align:center;font-weight:800;font-size:18px">Awaiting input...</div></div>';
    }
    else if(n===11){
      const alerts=data.alerts||[];
      h+='<div class="kpi-grid"><div class="kpi-card red"><div class="kpi-label">Active Alerts</div><div class="kpi-value">'+alerts.length+'</div><i class="fas fa-bell bg-icon"></i></div></div>';
      alerts.forEach(u=>{
        u.alerts.forEach(a=>{
          h+='<div class="alert-card '+a.severity+'"><strong>'+u.unit+' - '+a.type+'</strong><p>'+a.message+'</p></div>';
        });
      });
    }
    else if(n===12){
      h+='<div class="chart-container"><h3 style="margin-bottom:20px;color:var(--green-dark)">Budget Scenario Simulator</h3><div style="display:flex;gap:15px;align-items:center;margin-bottom:20px"><input id="sc-pct" type="number" value="10" style="padding:12px;border:2px solid var(--beige3);border-radius:10px;font-size:16px;width:120px;font-weight:800"/><span style="font-size:14px;font-weight:700">% Budget Increase</span><button class="strategy-btn" onclick="runScenario()">SIMULATE</button></div><div id="scenario-result" style="padding:20px;background:var(--beige);border-radius:12px;font-size:14px">Click SIMULATE to analyze.</div></div>';
    }
    else if(n===13){
      h+='<div class="chart-container"><h3 style="margin-bottom:20px;color:var(--green-dark)">MLOps Production Inference</h3><p>Test the containerized FastAPI endpoint (Port 8005)</p><div style="margin-top:20px"><input id="test-unit" type="text" value="ZHRT" style="padding:12px;border:2px solid var(--beige3);border-radius:10px;width:100%;font-size:14px;font-weight:600;margin-bottom:10px"/><button class="strategy-btn" onclick="testMLOps()" style="width:100%">RUN PRODUCTION INFERENCE</button></div><div id="mlops-res" style="margin-top:20px;padding:20px;background:var(--beige);border-radius:12px;font-family:monospace;font-size:13px;white-space:pre-wrap">Waiting for input...</div></div>';
    }

    el.innerHTML=h;
  }catch(err){
    el.innerHTML='<div style="color:var(--red);padding:30px;font-weight:800">ERROR: '+err.message+'</div>';
  }
}

function makeTable(headers,rows){
  let t='<div class="chart-container" style="margin-top:20px"><table><thead><tr>';
  headers.forEach(h=>{t+='<th>'+h+'</th>';});
  t+='</tr></thead><tbody>';
  rows.forEach(r=>{t+='<tr>';r.forEach(c=>{t+='<td>'+c+'</td>';});t+='</tr>';});
  t+='</tbody></table></div>';
  return t;
}

function showStrategicBI(el){
  el.innerHTML=`
  <div class="dashboard-header"><h2><i class="fas fa-chart-pie"></i> Strategic Power BI Dashboard</h2><button class="btn-refresh" onclick="loadObj(14,document.querySelector('.nav-item.active'))"><i class="fas fa-redo"></i> Refresh</button></div>
  <div class="kpi-grid">
    <div class="kpi-card green"><div class="kpi-label">Data Source</div><div class="kpi-value">DW</div><div class="kpi-sub">Active connection</div><i class="fas fa-database bg-icon"></i></div>
    <div class="kpi-card gold"><div class="kpi-label">ML Models</div><div class="kpi-value">12</div><div class="kpi-sub">Trained on startup</div><i class="fas fa-brain bg-icon"></i></div>
    <div class="kpi-card orange"><div class="kpi-label">DSS Objectives</div><div class="kpi-value">15</div><div class="kpi-sub">Per specification</div><i class="fas fa-list-check bg-icon"></i></div>
    <div class="kpi-card red"><div class="kpi-label">Role</div><div class="kpi-value">${currentRole.toUpperCase()||'ADMIN'}</div><div class="kpi-sub">Authenticated</div><i class="fas fa-user-shield bg-icon"></i></div>
  </div>
  <div style="display:grid;grid-template-columns:2fr 1fr;gap:30px">
    <div class="chart-container"><div class="chart-header"><h3>Diagnostic: Participants vs. Members</h3></div><canvas id="strategicChart" height="220"></canvas></div>
    <div class="insight-card"><div class="insight-icon">&#127942;</div><div class="insight-text"><h4>Performance Insight</h4><p>The association maintains a healthy growth trajectory. Units with >70% participation show 15% higher retention.</p><div style="background:#edf2ed;padding:15px;border-radius:10px;color:var(--green-dark);font-weight:700;font-size:12px;margin-bottom:20px">STRATEGY: FOCUS ON UNIT ASFR</div><button class="strategy-btn" onclick="loadObj(5,document.querySelectorAll('.nav-item')[4])">Analyze Unit Performance</button></div></div>
  </div>`;
  setTimeout(()=>{
    const ctx=document.getElementById('strategicChart');
    if(ctx){new Chart(ctx,{type:'bubble',data:{datasets:[{label:'Unit Performance',data:[{x:38,y:18,r:10},{x:49,y:58,r:12},{x:55,y:91,r:15},{x:62,y:65,r:14},{x:65,y:50,r:10},{x:72,y:59,r:11},{x:81,y:88,r:13}],backgroundColor:'#1e4d2b',borderColor:'#b5860d',borderWidth:2}]},options:{responsive:true,scales:{y:{title:{display:true,text:'Total Members',font:{weight:'bold'}},min:0,max:100},x:{title:{display:true,text:'Participation Rate (%)',font:{weight:'bold'}},min:35,max:85}},plugins:{legend:{display:false}}}});}
  },100);
}

async function runWeather(){
  const t=document.getElementById('w-temp').value;
  const r=document.getElementById('w-rain').value;
  const w=document.getElementById('w-wind').value;
  const res=document.getElementById('weather-result');
  try{
    const resp=await fetch('/api/obj/10',{method:'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify({temp:t,rain:r,wind:w})});
    const d=await resp.json();
    res.style.background=d.color==='green'?'#e8f5e9':d.color==='red'?'#ffeaea':'#fff5e6';
    res.style.color=d.color==='green'?'var(--green-dark)':'var(--red)';
    res.textContent=d.status+': '+d.recommendation;
  }catch(e){res.textContent='Error: '+e.message;}
}

async function runScenario(){
  const pct=document.getElementById('sc-pct').value;
  const res=document.getElementById('scenario-result');
  try{
    const resp=await fetch('/api/obj/12',{method:'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify({increase_pct:pct})});
    const d=await resp.json();
    res.innerHTML='<strong>Base Budget:</strong> '+Math.round(d.base_budget).toLocaleString()+' TND<br><strong>New Budget:</strong> '+Math.round(d.new_budget).toLocaleString()+' TND<br><strong>Surplus:</strong> '+Math.round(d.surplus).toLocaleString()+' TND<br><strong>Extra Per Unit:</strong> '+Math.round(d.extra_per_unit).toLocaleString()+' TND';
  }catch(e){res.textContent='Error: '+e.message;}
}

async function testMLOps(){
  const unit=document.getElementById('test-unit').value;
  const res=document.getElementById('mlops-res');
  res.textContent='Querying MLOps Gateway...';
  try{
    const resp=await fetch('/mlops/predict',{method:'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify({unit_code:unit,annee:2026})});
    const d=await resp.json();
    res.textContent=JSON.stringify(d,null,2);
  }catch(e){res.textContent='Error: '+e.message;}
}
</script>
</body>
</html>
"""
with open(target,'a',encoding='utf-8') as f:
    f.write(js)
print("Part 3 done: JavaScript engine written. FULL FILE COMPLETE.")
