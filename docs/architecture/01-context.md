# Architecture context and boundaries — draft

```text
Mac/Windows desktop browser (React) -- HTTPS/WebSocket --> OCI Java application service
                              |                              |
Browser-local deck library -- selective upload --> game room / auth / deck validation
                                                             |
                                          authoritative XMage adapter (candidate)
                                                /           |           \
                                         Human actions   AI controller  headless simulation
                                                             |
                                        PostgreSQL (accounts, rooms, metadata, audit)
```

## Hard architectural invariants
1. Only the authoritative Java engine processes MTG rules, actions and state transitions.
2. Clients and AI use identical legal-action/choice contracts; view filtering is per authenticated player.
3. The gameplay AI is independent of the external/local Ollama deck-recommendation service.
4. No hidden zones are copied to unauthorized users or spectators.
5. Game execution does not require an HTTP server, Swing, JavaFX, browser or display.
6. Simulations and interactive games must share rules implementation and version identifiers.
7. Cover every Commander-legal Oracle card with separately versioned functional verification evidence; absence of a test is not passing.

## Interfaces to design and prove in the next steps
- createGame(formatConfig, deckSnapshots, seed) -> gameId
- getObservation(gameId, principal) -> redactedObservation
- getLegalActions(gameId, principal) -> legalActionSet
- submitChoice(gameId, principal, revision, choice) -> validatedResult
- getGameEvents(gameId, permissionScope) -> filteredEventStream
- resumeGame(gameId, revision) -> authoritativeRecoveryResult

These are **conceptual contracts**, not working code or promises about XMage API compatibility.

## Risks
- XMage server and UI integration surfaces may require adapters; reject any duplicated rules logic.
- User's 'disconnect = loss' preference needs bounded heartbeat grace, explicit state transitions and protection from false disconnects.
- Browser-local decks are device/profile specific; deterministic export and backup are mandatory.
- Local Ollama means AI recommendations may be unavailable to friends unless safely deployed or delegated; no paid hosted model.
- Distinct license obligations for XMage, Forge, Scryfall and Wizards IP; no unsupported claim that private sharing eliminates obligations.
