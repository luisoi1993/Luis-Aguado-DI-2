# AI Coding Guidelines for GestionTareasFinal

## Project Overview
This is an Angular 21 application for task management ("gestionTareasFinal") using NgModule architecture with Server-Side Rendering (SSR) enabled. The project follows Angular CLI conventions with custom Prettier formatting.

## Architecture Patterns
- **NgModule-based**: Use `@NgModule` declarations/imports instead of standalone components (schematics configured with `standalone: false`)
- **SSR Support**: Includes server-side rendering with Express; use `serve:ssr:gestionTareasFinal` script for production SSR testing
- **Component Structure**: Prefer `templateUrl` and `styleUrl` over inline templates/styles (see `src/app/app.ts`)
- **Prefix**: All components use `app-` prefix

## Development Workflows
- **Serve**: `npm start` or `ng serve` for development server at `http://localhost:4200/`
- **Build**: `npm run build` or `ng build` outputs to `dist/` with SSR bundles
- **Test**: `npm test` or `ng test` uses Vitest runner
- **SSR Serve**: `npm run serve:ssr:gestionTareasFinal` for server-side rendered version

## Code Style & Conventions
- **Prettier Config**: 100 char width, single quotes, Angular parser for HTML files
- **TypeScript**: Strict mode enabled with `strictTemplates: true`, `noImplicitOverride: true`, etc.
- **Schematics**: Skip tests by default (`skipTests: true`) for components, services, etc.
- **Imports**: Use relative imports within app; absolute for Angular/core

## Key Files
- `src/app/app-module.ts`: Main app module with hydration providers
- `src/app/app-routing-module.ts`: Routing configuration (currently empty)
- `angular.json`: Schematics config enforces NgModule pattern
- `tsconfig.json`: Strict TypeScript settings for templates and injection

## Integration Points
- **SSR**: `src/main.server.ts` and `src/server.ts` for server-side rendering
- **Hydration**: Enabled with event replay in `app-module.ts`

Focus on building task management features using Angular Forms and Router within the NgModule structure.