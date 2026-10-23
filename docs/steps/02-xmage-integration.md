# Step 02 — XMage integration (IN PROGRESS, NOT COMPLETE)

## Evidence from owner's Windows workstation
- XMage pinned to `5ccb0af240`.
- `mvn -B clean test -pl Mage.Tests -am` returned exit code 0: 7,133 tests run, 0 failures/errors, 126 skipped.
- `mvn -B -e install -DskipTests -pl Mage.Server.Plugins/Mage.Game.CommanderFreeForAll,Mage.Server.Plugins/Mage.Player.AI -am` returned exit code 0, with successful local install of required engine/AI/Commander artifacts.
- Earlier intermittent `mage-sets` JAR failures occurred on different `.class` paths; root cause not established. Latest install succeeded.

## Added in this work-in-progress package
- Backend Maven project with `org.mage` 1.4.62 dependencies and JUnit 4 smoke test.
- Canonical branding changed for new code and config to **MTG Commander Simulator**. Historical Step 01 documents are kept as audit evidence and may mention the prior working name.
- New smoke test loads real XMage classes and checks constructor shape; it is not a playable Commander test.

## Verify locally on Windows (from project root)
1. Confirm your Maven local repository contains the three artifacts above.
2. Run: `mvn -f backend/pom.xml -B clean test`
3. Report the exit code and last 60 log lines; fix any dependency/classloading issues.

## Remaining acceptance criteria
- Create 2-, 3-, 4-player Commander matches programmatically.
- Load valid complete decks, initialize real game state, submit validated actions and observe player-specific state.
- Drive a four-AI headless game to completion with safeguards and event trace.
- Establish deterministic seed and repeatability and cover rules interactions with tests.
- Package a verified complete Step 02 ZIP.

No backend XMage execution was available in the packaging environment. Do not represent the Maven smoke test as locally passed until run on Windows.
