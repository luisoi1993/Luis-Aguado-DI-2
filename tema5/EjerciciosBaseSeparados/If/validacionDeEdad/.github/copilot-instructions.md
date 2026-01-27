# Copilot Instructions for ValidacionDeEdad

## Architecture Overview
This is an Angular 21 application with Server-Side Rendering (SSR) enabled, using a module-based architecture instead of standalone components. The app focuses on age validation functionality, with routing and forms integrated.

- **Key Components**: Main app component in `src/app/app.ts`, module in `src/app/app-module.ts`.
- **Data Flow**: Uses Angular Forms for user input validation, signals for reactive state management.
- **SSR Setup**: Configured via `angular.json` with server entry at `src/server.ts`.

## Developer Workflows
- **Development**: Run `ng serve` to start dev server with hot reload at `http://localhost:4200`.
- **Build**: Use `ng build` for production builds; SSR builds to `dist/validacionDeEdad/server/server.mjs`.
- **Testing**: Execute `ng test` with Vitest; tests are skipped by default in generated schematics.
- **SSR Serving**: After build, run `npm run serve:ssr:validacionDeEdad` for server-side rendered app.

## Project Conventions
- **Component Style**: Use NgModules (not standalone); declare components in modules like in `src/app/app-module.ts`.
- **Code Generation**: Schematics skip tests (`skipTests: true`); prefix components with "app".
- **Styling**: CSS variables defined in component styles; follow Angular's style guide.
- **Forms**: Import `FormsModule` in modules for template-driven forms.
- **State Management**: Use Angular signals for reactive properties, e.g., `signal('value')` in components.
- **Hydration**: Enabled with event replay for SSR compatibility.

## Dependencies & Integrations
- **Core**: Angular 21 with Router, Forms, SSR.
- **Build Tool**: Angular CLI with application builder.
- **Linting/Formatting**: Prettier configured in `package.json` with `printWidth: 100`, `singleQuote: true`, Angular parser for HTML.

## Examples
- Module setup: See `src/app/app-module.ts` for imports and providers.
- Component: `src/app/app.ts` uses signals and template URL.
- Config: `angular.json` defines budgets (500kB initial, 1MB max) and SSR options.

Follow these patterns for consistent contributions.</content>
<parameter name="filePath">c:\Users\luis\Documents\GitHub\Luis-Aguado-DI-2\tema5\validacionDeEdad\.github\copilot-instructions.md