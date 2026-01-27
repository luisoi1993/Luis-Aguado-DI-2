# AI Coding Guidelines for IconoDinamico

## Project Overview
This is an Angular 21 application with Server-Side Rendering (SSR) and prerendering, focused on dynamic icon functionality. The app uses a module-based architecture with signals for reactive state management.

## Architecture
- **Framework**: Angular 21 with SSR (@angular/ssr)
- **Build**: @angular/build application builder
- **Rendering**: Prerender mode for all routes (serverRoutes in `app.routes.server.ts`)
- **State**: Signals for reactive data (e.g., `signal('iconoDinamico')` in `app.ts`)
- **Modules**: Traditional NgModule-based (not standalone components)
- **Server**: Express.js with AngularNodeAppEngine

## Key Files
- `src/app/app.ts`: Main app component using signals
- `src/app/app-module.ts`: Root module with hydration (withEventReplay)
- `src/server.ts`: Express server setup for SSR
- `angular.json`: Schematics configured to skip tests, standalone: false

## Development Workflow
- **Serve**: `ng serve` (starts dev server on localhost:4200)
- **Build**: `ng build` (outputs to dist/, production with hashing)
- **Test**: `ng test` (Vitest runner)
- **SSR Serve**: `npm run serve:ssr:iconoDinamico` (production SSR)

## Code Conventions
- **TypeScript**: Strict mode enabled (noImplicitOverride, noPropertyAccessFromIndexSignature, etc.)
- **Prettier**: printWidth: 100, singleQuote: true, angular parser for HTML files
- **Components**: Non-standalone (NgModule declarations)
- **Schematics**: Automatically skip test generation (--skip-tests)
- **Imports**: Use relative paths within app/

## Patterns
- Use signals for component state: `protected readonly title = signal('value');`
- Module structure: Separate routing module (`app-routing-module.ts`)
- SSR setup: Separate server module (`app.module.server.ts`) and routes (`app.routes.server.ts`)
- Hydration: Enabled with event replay for SSR compatibility

## Testing
- Framework: Vitest (configured in `tsconfig.spec.json`)
- Excludes spec files from app build
- Run tests: `ng test`

## Deployment
- Prerendered static files for performance
- Express server handles dynamic requests
- Budgets: Initial 500kB (warn), 1MB (error); component styles 4kB (warn), 8kB (error)