# Phase 1 engine feasibility audit — preliminary

## Evidence available as of 2026-10-22
- XMage repository: https://github.com/magefree/mage . Public repository lists modules `Mage`, `Mage.Server`, `Mage.Common`, `Mage.Sets`, `Mage.Tests`, `Mage.Client`; README describes server-side rule enforcement, Commander, multiplayer and AI. Repository is described as MIT-licensed. **This is preliminary source metadata, not a code-level integration audit.**
- XMage architecture overview: https://github-wiki-see.page/m/magefree/mage/wiki/Project-Overview . Historical documentation suggests RMI server and separate Swing client; current source must be checked.
- Forge repository: https://github.com/Card-Forge/forge . GPL-3.0 indicated; may be studied as implementation reference. **Do not copy Forge source** before completing legal review.
- Oracle Always Free: https://docs.oracle.com/en-us/iaas/Content/FreeTier/freetier.htm . Do not rely on stale quota figures; query actual limits and confirm Free Tier eligibility.

## Attempted verification
- `git ls-remote https://github.com/magefree/mage.git HEAD` -> FAILED: could not resolve host github.com in current execution environment.
- `requests.get(raw.githubusercontent.com/.../pom.xml)` -> FAILED: DNS/network blocked.
- No XMage checkout obtained; no Maven/engine build or Commander test performed.

## Phase 1 REQUIRED acceptance gates (all OPEN)
- [ ] Record pinned XMage commit hash, license texts and transitive dependencies.
- [ ] Review implementation modules and headless action/state API.
- [ ] Build XMage with supported JDK/toolchain, record exact commands/results.
- [ ] Drive 2-, 3-, 4-player Commander games without client UI.
- [ ] Complete one four-AI Commander game with real cards and legal actions.
- [ ] Prove identical seed/decks/action trace produces equivalent authoritative results.
- [ ] Prove individual observations do not disclose opponent hidden cards.
- [ ] Benchmark memory/CPU on ARM64 or representative ARM64 target.
- [ ] Verify card coverage registry can map catalog IDs to implemented classes.
- [ ] Analyze actual licensing and artifact redistribution requirements.
- [ ] Produce interface adapter API and architecture decision record.

**Conclusion: feasibility is NOT yet established. Phase 1 remains open.**
