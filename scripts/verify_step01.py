#!/usr/bin/env python3
"""Dependency-free scaffold verification. DOES NOT test Magic rules, XMage or deployment."""
from pathlib import Path
import json, shutil, subprocess, sys
root=Path(__file__).resolve().parents[1]
required=['README.md','config/project.json','docs/architecture/01-context.md','docs/audits/01-engine-feasibility.md','docs/steps/01-foundation.md','backend/src/main/java/com/quantumchronos/bootstrap/Bootstrap.java','backend/src/test/java/com/quantumchronos/bootstrap/BootstrapTest.java']
for name in required:
    if not (root/name).is_file():
        raise SystemExit(f'FAIL missing {name}')
print('PASS required project files')
config=json.loads((root/'config/project.json').read_text())
assert config['budget_usd_monthly']==0
assert config['region']=='us-ashburn-1'
assert config['players']==[2,3,4]
assert config['client_install_required'] is False
assert len(config['ai_components'])==2
print('PASS non-negotiable configuration checks')
if not shutil.which('javac') or not shutil.which('java'):
    print('SKIP Java test: JDK missing; install JDK and rerun before accepting local smoke test')
    sys.exit(2)
out=root/'build'/'classes';out.mkdir(parents=True,exist_ok=True)
source=root/'backend/src/main/java/com/quantumchronos/bootstrap/Bootstrap.java'
test=root/'backend/src/test/java/com/quantumchronos/bootstrap/BootstrapTest.java'
subprocess.run(['javac','-d',str(out),str(source),str(test)],check=True)
run=subprocess.run(['java','-cp',str(out),'com.quantumchronos.bootstrap.BootstrapTest'],check=True,capture_output=True,text=True)
assert 'PASS BootstrapTest' in run.stdout
print(run.stdout.strip())
print('PASS step-01 scaffold verification (NOT MTG engine verification)')
