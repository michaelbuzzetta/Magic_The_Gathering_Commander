# MTG Commander Simulator

**Status: Step 02 IN PROGRESS; no playable Commander game yet.**

This complete-source work-in-progress ZIP builds on the previously delivered Step 01 scaffold. XMage source is an **external dependency** pinned to commit `5ccb0af240` and is not bundled in this small archive. The owner has verified clean XMage tests and Maven installation on Windows.

From the project root on Windows, with Maven and installed XMage artifacts:

```powershell
mvn -f backend/pom.xml -B clean test
```

The new integration test checks the real XMage classpath and constructor signatures; it **does not** start an actual match. See `docs/steps/02-xmage-integration.md` and the master charter for the remaining criteria.

The project's name is **MTG Commander Simulator**. Some archival Step 01 documents mention its former working title and are kept for audit traceability. User-facing clients must install nothing; OCI budget is strictly $0.
