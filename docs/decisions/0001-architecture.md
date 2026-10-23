# ADR 0001 — Non-negotiable system boundaries

Status: PROVISIONAL (user requirements confirmed; feasibility pending)

- Runtime target: OCI Free Tier, us-ashburn-1; no paid resources or services.
- Client: browser-only, Mac/Windows desktop first.
- Authoritative rules engine: XMage candidate, single source of legality.
- Forge: study only pending GPL compatibility review.
- Gameplay AI and Ollama-based deck AI are separate and have independent failure domains.
- Persistent decks are browser-local by default; deck snapshot transmitted for match.
- User requested public GitHub and later source privacy: resolve BEFORE setting repo visibility. Do not automatically publish.
- Completion criteria are evidence-based; no unverified card coverage claims.
