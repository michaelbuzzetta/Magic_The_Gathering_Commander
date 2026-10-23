# QuantumChronOS — MTG Commander Simulator

**Status:** Foundation scaffold only. **NO playable game, integrated XMage rules engine, or OCI deployment yet.**

Desktop-browser Commander application for 2–4 players, humans and AI, with accurate server-side rules, online private rooms, deck tools and headless tournament simulations.

## Non-negotiables
- Use one authoritative XMage-based Java rules engine subject to feasibility, licensing and live integration tests.
- Full legal Commander card coverage must be **proved**, not inferred from catalog imports.
- No payment obligations: OCI Free Tier home region `us-ashburn-1`, maximum $0 cost.
- User and friends require only a web browser on macOS/Windows; developer uses VS Code.
- Private rooms; no public matchmaking; disconnected player loses under explicit policy (grace and network semantics still to be designed).
- Distinct gameplay AI and deck-building AI. Local Ollama is a target for deck assistance, not a deployed dependency today.
- Private deck library in the user's browser, user-controlled import/export; selected decks are transmitted for playing.
- At the end of **each verified step**, supply whole-project ZIP and await next user instruction.

## This package contains
- A dependency-free Java proof-of-life build with a test that can run under Java 21 without Maven.
- Interface contracts for future integration (no pretend MTG behavior).
- Architecture, audit, OCI/security/licensing decisions, and test/verification tracking.
- A self-check script for package structure, policy invariants and Java bootstrap.

## Developer quick start
1. Open this directory in VS Code.
2. Run `python3 scripts/verify_step01.py` (macOS/Windows; on Windows `py scripts/verify_step01.py`).
3. Optional, Java separately: `javac -d build/classes backend/src/main/java/com/quantumchronos/bootstrap/Bootstrap.java` and `java -cp build/classes com.quantumchronos.bootstrap.Bootstrap`.
4. Read `docs/steps/01-foundation.md` and `docs/audits/01-engine-feasibility.md`.

## Status and next step
Step 01 scaffold tests run in build environment. **Phase 1 XMage source/build/headless audit is BLOCKED here** because GitHub DNS/network access is unavailable; a separate checked-out copy or network-enabled execution environment is required. Step 02 must not claim XMage integration until a real match test executes.

## External source links
- XMage: https://github.com/magefree/mage (MIT license indicated by repository; audit actual license and dependencies at pinned commit)
- Forge: https://github.com/Card-Forge/forge (GPL-3.0; research only until license review)
- Oracle Always Free: https://docs.oracle.com/en-us/iaas/Content/FreeTier/freetier.htm (verify limits within tenancy)
