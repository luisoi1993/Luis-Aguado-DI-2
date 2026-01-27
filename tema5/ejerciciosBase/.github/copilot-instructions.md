# AI Coding Guidelines for EjerciciosBase

## Project Overview
This is an Angular 21 application with Server-Side Rendering (SSR) enabled using `@angular/ssr`. The app uses NgModules for component organization rather than standalone components. SSR is configured for prerendering all routes with client-side hydration and event replay.

The application features a main App component that switches between two exercise modules: `Mensajerol` (role-based user messages) and `Mostrarocultarmensaje` (show/hide welcome message) using `ngSwitch` based on a select dropdown.

## Architecture Patterns
- **Component Structure**: Use separate `.ts`, `.html`, and `.css` files. Components are declared in modules, not standalone.
  - Example: `App` component in `src/app/app.ts` with `templateUrl: './app.html'` and `styleUrl: './app.css'`, `standalone: false`
- **Routing**: Centralized in `AppRoutingModule` (`src/app/app-routing-module.ts`). Add routes to the `routes: Routes = []` array.
- **Modules**: Main app module in `src/app/app-module.ts` declares components and imports routing. Server module in `src/app/app.module.server.ts` for SSR.
- **State Management**: Use Angular signals for reactive component state (e.g., `protected readonly title = signal('ejerciciosBase')` in `src/app/app.ts`).
- **Control Flow**: Use `@if`/`@else` for template conditionals (e.g., in `mensajerol.html`), alongside `*ngIf` for structural directives.
- **SSR Setup**: Server entry at `src/main.server.ts`, client hydration enabled with event replay (`provideClientHydration(withEventReplay())` in `src/app/app-module.ts`). Prerendering configured in `src/app/app.routes.server.ts`.

## Development Workflows
- **Serve**: `ng serve` starts dev server at `http://localhost:4200/` with hot reload.
- **Build**: `ng build` outputs to `dist/` with SSR support.
- **Test**: `ng test` runs Vitest unit tests.
- **SSR Serve**: `npm run serve:ssr:ejerciciosBase` serves the built SSR app.

## Code Conventions
- **Component Prefix**: Use `app-` prefix for selectors (configured in `angular.json`).
- **Schematics**: Generate components, services, etc., with `ng generate` – tests are skipped by default (`skipTests: true` in `angular.json`), `standalone: false` for components/directives/pipes.
- **Formatting**: Prettier configured with 100 char width, single quotes, Angular HTML parser (in `package.json`).
- **Imports**: Use relative paths for app-internal files (e.g., `'./app-routing-module'`).
- **Forms**: Use `FormsModule` for two-way binding with `[(ngModel)]` (e.g., select dropdowns in `app.html` and `mensajerol.html`).
- **Event Handling**: Use `(click)` for button events (e.g., `toggleMensaje()` in `mostrarocultarmensaje.ts`).

## Key Files
- `src/app/app.ts`: Root component with signal-based title and component switching logic.
- `src/app/app-routing-module.ts`: Route definitions (currently empty).
- `src/app/app-module.ts`: Module declarations and providers, including hydration.
- `angular.json`: Build config with SSR options and schematics settings (skipTests, standalone: false).
- `src/app/app.module.server.ts`: Server module for SSR with prerendering routes.
- `src/app/modules/`: Directory for feature modules like `mensajerol` and `mostrarocultarmensaje`.

## Dependencies
- Angular 21 core with Forms, Router, SSR.
- Express for server-side rendering.
- RxJS for reactive programming.

Follow these patterns to maintain consistency with the existing modular Angular structure.