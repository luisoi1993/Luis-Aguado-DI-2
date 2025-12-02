<!-- .github/copilot-instructions.md -->

# Copilot / AI assistant instructions for this repository

Purpose: Help AI coding agents be immediately productive with this small static-site project.

- Project type: simple static front-end site. Primary entry: `index.html` at repository root.
- Primary folders: `utils/js/` (JavaScript), `utils/assets/` (images, styles, vendor files).

What to do first

- Open and edit `index.html` for page structure and include scripts from `utils/js/`.
- Add new JS modules under `utils/js/` and assets under `utils/assets/`.

How to run & test locally

- No build system or package manifest detected. The site is static — open `index.html` in a browser.
- For a quick local server (recommended), from the repo root run:

```powershell
python -m http.server 8000
# then open http://localhost:8000/
```

Project-specific patterns and conventions

- Keep JavaScript files in `utils/js/` and reference them with relative `<script src="utils/js/<name>.js"></script>` tags in `index.html`.
- Place images, fonts, and other static assets in `utils/assets/` and reference with relative paths (e.g. `utils/assets/logo.png`).
- There is no transpilation step: write browser-friendly ES modules or plain scripts targeting modern browsers.

Files to look at for examples

- `index.html` — the document head is present; add markup, scripts, and stylesheet links here.
- `utils/js/` and `utils/assets/` — currently empty; use these locations for new code and static assets.

When merging with existing AI guidance

- If a `.github/copilot-instructions.md` already exists, merge by preserving any project-specific rules (file paths, commands) and adding or replacing only outdated or missing sections. Prefer specific commands found in the repo over generic suggestions.

Limitations & assumptions (discoverable from repo)

- There is no package.json, Makefile, or build config in the repo root. Do not assume Node, npm, or other toolchains unless you find them in the workspace.
- No tests or CI configuration detected; suggest test scaffolding only when requested.

Example snippets

- Add a script tag to `index.html`:

```html
<script src="utils/js/main.js"></script>
```

- Serve with Python (PowerShell): `python -m http.server 8000`.

If anything here is unclear or you need more repository-specific examples (routing, frameworks, or build steps), ask the repo owner to add a README or point to the files that implement those patterns.

— End
