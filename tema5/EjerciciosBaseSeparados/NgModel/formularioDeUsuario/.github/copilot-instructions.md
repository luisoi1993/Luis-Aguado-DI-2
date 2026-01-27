# Copilot Instructions for FormularioDeUsuario

## Architecture Overview
- **Framework**: Angular 21 with Server-Side Rendering (SSR) enabled
- **Component Style**: Module-based architecture (not standalone components)
- **State Management**: Uses Angular signals for reactive state (e.g., `signal('value')` in components)
- **Routing**: Configured via `AppRoutingModule` with empty routes array for single-page apps
- **Forms**: `@angular/forms` available for reactive/template-driven forms

## Key Files and Structure
- `src/app/app-module.ts`: Main app module with hydration and error listeners
- `src/app/app-routing-module.ts`: Routing configuration (extend routes here for multi-page apps)
- `src/app/app.ts`: Root component using signals and external templates/styles
- Component pattern: `@Component({ selector: 'app-*', templateUrl: './*.html', styleUrl: './*.css', standalone: false })`

## Development Workflow
- **Serve**: `ng serve` (runs on http://localhost:4200 with auto-reload)
- **Build**: `ng build` (outputs to `dist/`, production optimized with SSR)
- **Test**: `ng test` (uses Vitest runner)
- **SSR Serve**: `npm run serve:ssr:formularioDeUsuario` for server-side rendered builds

## Code Conventions
- **TypeScript**: Strict mode enabled with `noImplicitOverride`, `noPropertyAccessFromIndexSignature`, etc.
- **Angular Compiler**: Strict templates, injection parameters, and input access modifiers
- **Prettier**: Configured in `package.json` with `printWidth: 100`, `singleQuote: true`, Angular parser for HTML
- **Schematics**: Generate components/directives/pipes/services with `skipTests: true` and `standalone: false`
- **Imports**: Use relative paths for app-internal modules

## Patterns and Examples
- Components extend classes with signals: `export class Component { protected readonly prop = signal(initial); }`
- Modules import `BrowserModule` and routing, provide hydration with event replay
- Avoid standalone components; use NgModule declarations instead

## Dependencies
- Core: `@angular/core`, `@angular/forms`, `@angular/router`
- SSR: `@angular/ssr` with Express server
- Build: `@angular/build` and CLI for tooling