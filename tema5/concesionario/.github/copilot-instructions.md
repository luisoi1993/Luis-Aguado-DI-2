# Copilot instructions — Concesionario (Angular + SSR)

Purpose: quick, actionable guidance so an AI coding agent can be immediately productive in this repository.

---

## Big picture 🧭
- This is an Angular 21 application configured for Server-Side Rendering (SSR) via `@angular/ssr` and a small Express wrapper.
- Browser entry: `src/main.ts` → bootstraps `AppModule`.
- Server entry: `src/main.server.ts` and `src/server.ts` → Express handler that uses `AngularNodeAppEngine` to render pages and optionally serve API endpoints.
- Output of builds lands in `dist/concesionario` (see `angular.json`).

## Quick dev / build commands ⚙️
- Start dev server (fast iteration): `npm start` (runs `ng serve`, default port 4200).
- Run tests: `npm test` (`ng test`, Vitest by Angular setup – note: no unit tests present by default).
- Build for production: `npm run build` (`ng build`).
- Run SSR server after building: `npm run serve:ssr:concesionario` (runs `node dist/concesionario/server/server.mjs`, default port 4000).

Examples:
- Full SSR flow: `npm run build && npm run serve:ssr:concesionario` → visit `http://localhost:4000`.
- Dev-only: `npm start` → visit `http://localhost:4200`.

## Project-specific conventions & patterns 🔧
- Generated schematics are configured to **skip tests** and produce **non-standalone components** by default (see `angular.json` → `schematics`). If you need tests, generate with `--skip-tests=false`.
- The app uses the Angular Signals API (see `src/app/app.ts` — `signal('concesionario')`) and client hydration (`provideClientHydration(withEventReplay())`) in `src/app/app-module.ts`.
- Server routing: `src/app/app.routes.server.ts` currently defines a catch-all route (`path: '**'`) with `RenderMode.Prerender`.
- Add Express API endpoints directly in `src/server.ts` before static file / Angular middleware. Example snippet to add a REST endpoint:

    ```ts
    // src/server.ts
    app.get('/api/cars', (req, res) => {
      res.json([{ id: 1, make: 'Toyota' }]);
    });
    ```

- Static assets served from `public/` (configured in `angular.json` assets).

## Files to inspect/modify most often 📂
- `src/server.ts` — Express wrapper and SSR handler; where to add API endpoints and control server behavior (ports, logging).
- `src/main.server.ts` — server entrypoint (exports AppServerModule).
- `src/app/app.module.server.ts` and `src/app/app.routes.server.ts` — server rendering config and routes.
- `src/app/*` — app components, bootstrapping, signals/hydration usage.
- `angular.json` and `package.json` — build & script configuration.

## Tests & CI notes ✅
- `ng test` is configured, but no tests are present. If adding tests, follow Angular CLI defaults unless you opt-in to standalone components.

## Debugging tips 🐞
- Dev debugging: `ng serve` (hot reload, source maps enabled under `development`).
- SSR debugging: build then run `npm run serve:ssr:concesionario`; server logs print to stdout; default server port is 4000.

## Safety & scope boundaries ⚠️
- There are no external API integrations or credentials in the repo. If you add environment variables or secrets for APIs, keep them out of source and document their usage in README.

---

If anything is unclear or you'd like additional examples (routing, component patterns, or a suggested test for an example component), tell me which area to expand. ✅
