# Copilot Instructions for mostrarMensajeSegunRol

## Project Overview
This is an Angular 21 application with Server-Side Rendering (SSR) support, designed to display messages based on user roles. The project uses NgModules (non-standalone components) and follows Angular CLI conventions.

## Architecture
- **Framework**: Angular 21 with SSR enabled via `@angular/ssr`
- **Module System**: Uses NgModules; components are not standalone (see `angular.json` schematics)
- **Routing**: Basic routing setup in `app-routing-module.ts` (currently empty)
- **State Management**: Uses Angular signals for reactive state (e.g., `title` signal in `app.ts`)
- **Build Tool**: Angular CLI with application builder
- **Testing**: Vitest integrated via `ng test`

## Development Workflow
- **Start Dev Server**: `ng serve` or `npm start` (serves on http://localhost:4200 with auto-reload)
- **Build**: `npm run build` (outputs to `dist/` with SSR support)
- **Test**: `npm test` (runs Vitest)
- **Watch Mode**: `npm run watch` for continuous building
- **SSR Serve**: `npm run serve:ssr:mostrarMensajeSegunRol` for server-side rendering

## Code Conventions
- **Component Prefix**: `app-` (configured in `angular.json`)
- **File Naming**: Kebab-case for files (e.g., `app-routing-module.ts`)
- **Code Style**: Prettier with 100 char width, single quotes, Angular HTML parser
- **Schematics**: Skip tests by default for all generated items
- **Imports**: Use relative paths within `src/app/`
- **Language**: Code in English, project name in Spanish

## Key Patterns
- **Component Structure**: Template in separate `.html`, styles in `.css`, logic in `.ts`
- **Signals Usage**: Prefer signals for reactive properties (e.g., `protected readonly title = signal('...')`)
- **Module Declaration**: Declare components in `AppModule` imports array
- **SSR Hydration**: Enabled with event replay for client-side hydration

## Key Files
- `src/app/app.ts`: Main component with signal-based title
- `src/app/app.html`: Template (currently default Angular welcome page)
- `src/app/app-module.ts`: Root module with SSR providers
- `angular.json`: Build config with SSR and non-standalone schematics
- `package.json`: Scripts and Prettier config

When adding features, generate components with `ng generate component --skip-tests` and integrate into `AppModule`.</content>
<parameter name="filePath">c:\Users\luis\Documents\GitHub\Luis-Aguado-DI-2\tema5\mostrarMensajeSegunRol\.github\copilot-instructions.md