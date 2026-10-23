# Infrastructure: planned, not provisioned

- OCI Free Tier, home region us-ashburn-1, spend ceiling $0.
- ARM64 Ampere capacity and Always Free quotas must be verified against account/region; no assumption of available capacity.
- No OCI keys or secrets in repository; never commit tenancy identifiers, Discord secrets, DB passwords, or auth tokens.
- Plan TLS reverse proxy, Java headless service, PostgreSQL, browser frontend, optional remote API for local Ollama only after threat model and performance feasibility.
- Deployment deliberately absent; creating paid resources is prohibited.
- Compute limits, external traffic limits, idle reclamation, boot volume counts, and network restrictions require audit.
