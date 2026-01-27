# AI Coding Guidelines for NumerarUnaLista

## Project Overview
This is an Angular 21 application with Server-Side Rendering (SSR) support. The app uses NgModules for component organization (not standalone components) and Angular signals for reactive state management.

## Architecture
- **Modules**: Use NgModules for feature organization. See `src/app/app-module.ts` for the root module setup.
- **Components**: Non-standalone components with templateUrl and styleUrl. Prefix: `app-`.
- **Routing**: Configured in `src/app/app-routing-module.ts` (currently empty routes).
- **SSR**: Enabled with hydration and event replay. Server entry at `src/server.ts`.

## Key Dependencies
- Angular 21 with FormsModule for template-driven forms.
- RxJS for reactive programming.
- Express for SSR server.

## Development Workflow
- **Start dev server**: `ng serve` (serves at http://localhost:4200)
- **Build**: `ng build` (outputs to `dist/`)
- **Test**: `ng test` (uses Vitest runner)
- **SSR serve**: `npm run serve:ssr:numerarUnaLista`

## Code Conventions
- **TypeScript**: Strict mode enabled with strict templates and injection parameters.
- **Prettier**: printWidth: 100, singleQuote: true, Angular parser for HTML files.
- **Schematics**: Skip tests by default, generate non-standalone components/directives/pipes.
- **Signals**: Use Angular signals for component state, e.g., `protected readonly title = signal('value');` in `src/app/app.ts`.

## Patterns
- Component structure: Class with @Component decorator, templateUrl, styleUrl.
- Module imports: BrowserModule, FormsModule, AppRoutingModule.
- Hydration: Enabled with event replay for SSR.

## File Structure
- `src/app/`: Application code
- `src/main.ts`: Browser bootstrap
- `src/main.server.ts`: Server bootstrap
- `public/`: Static assets

Reference `angular.json` for build configurations and budgets.</content>
<parameter name="filePath">c:\Users\luis\Documents\GitHub\Luis-Aguado-DI-2\tema5\numerarUnaLista\.github\copilot-instructions.md