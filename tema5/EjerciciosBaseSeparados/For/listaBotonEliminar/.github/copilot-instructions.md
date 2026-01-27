# AI Coding Guidelines for listaBotonEliminar

## Project Overview
This is an Angular 21 application with Server-Side Rendering (SSR) enabled, using NgModules instead of standalone components. The app is configured for prerendering all routes.

## Architecture
- **Modules**: Use NgModule-based architecture (see `src/app/app-module.ts`).
- **Routing**: Client-side routing via `AppRoutingModule` (`src/app/app-routing-module.ts`).
- **SSR**: Server-side rendering with hydration (see `src/app/app.module.server.ts`, `src/app/app.routes.server.ts`).
- **Components**: Non-standalone components with `standalone: false` (see `src/app/app.ts`).

## File Naming Conventions
- Module files use dashes: `app-module.ts`, `app-routing-module.ts`.
- Standard Angular file extensions otherwise (.ts, .html, .css).

## Code Style
- **Prettier**: Single quotes, printWidth 100, Angular parser for HTML files (see `package.json`).
- **Angular CLI Schematics**: Skip tests, generate non-standalone components/directives/pipes (see `angular.json`).

## Development Workflows
- **Start dev server**: `npm start` (ng serve).
- **Build**: `npm run build` (ng build).
- **Test**: `npm test` (ng test with Vitest).
- **SSR serve**: `npm run serve:ssr:listaBotonEliminar`.

## Key Files
- `src/app/app.ts`: Main app component using signals.
- `src/app/app.html`: Template with router outlet.
- `angular.json`: Build config with SSR and budgets.
- `package.json`: Scripts and Prettier config.

## Patterns
- Use signals for reactive state (e.g., `signal('value')` in components).
- Hydration enabled with event replay for SSR.
- Prerender all routes by default.</content>
<parameter name="filePath">c:\Users\luis\Documents\GitHub\Luis-Aguado-DI-2\tema5\listaBotonEliminar\.github\copilot-instructions.md