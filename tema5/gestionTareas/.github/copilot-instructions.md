# AI Coding Guidelines for GestionTareas

## Project Overview
This is an Angular 21 application for task management ("gestionTareas"). It uses NgModule architecture (not standalone components), includes SSR support, and is configured for development with npm.

## Architecture
- **Framework**: Angular 21 with NgModule-based components
- **Routing**: Configured in `src/app/app-routing-module.ts` (currently empty)
- **Forms**: Uses Angular Reactive/Template-driven forms via `FormsModule`
- **SSR**: Enabled with Express server (`src/server.ts`, `src/main.server.ts`)
- **Styling**: Global styles in `src/styles.css`, component styles in `*.css` files

## Development Workflow
- **Serve**: `npm start` or `ng serve` (runs on http://localhost:4200)
- **Build**: `npm run build` or `ng build` (outputs to `dist/`)
- **Watch mode**: `npm run watch` or `ng build --watch --configuration development`
- **SSR serve**: `npm run serve:ssr:gestionTareas` (after build)

## Code Generation
Angular CLI schematics are configured to skip test generation:
- Components: `ng generate component <name>` (creates in `src/app/`, prefix `app-`, no tests)
- Services: `ng generate service <name>` (no tests)
- All other schematics (guards, pipes, etc.) also skip tests

## Coding Conventions
- **TypeScript**: Strict mode enabled via `tsconfig.json`
- **Imports**: Use relative paths within `src/app/`
- **Component selector**: Prefix with `app-` (e.g., `<app-task-list>`)
- **File naming**: Kebab-case for files (e.g., `task-list.component.ts`), PascalCase for classes

## Formatting
Prettier configured in `package.json`:
- Print width: 100 characters
- Single quotes for strings
- Angular HTML parser for `*.html` files

## Key Files
- `src/app/app.ts`: Root component (signals-based)
- `src/app/app-module.ts`: Main NgModule with FormsModule and routing
- `angular.json`: Build configs, schematics settings
- `tsconfig.*.json`: TypeScript configurations for app/spec/server

## Patterns
- Use signals for reactive state in components (e.g., `title = signal('gestionTareas')`)
- Bootstrap via `AppModule` in `src/main.ts`
- SSR entry points: `src/main.server.ts` and `src/server.ts`

This is a starting project; add components/services as needed for task management features.</content>
<parameter name="filePath">c:\Users\luis\Documents\GitHub\Luis-Aguado-DI-2\tema5\gestionTareas\.github\copilot-instructions.md