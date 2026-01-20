# AI Coding Guidelines for mostrarOcultarMensaje

## Project Overview
This is an Angular 21 application with Server-Side Rendering (SSR) support, focused on demonstrating message show/hide functionality. The app uses Angular modules (not standalone components) and modern Angular features like signals.

## Architecture
- **Framework**: Angular 21 with SSR enabled
- **Component Style**: Module-based components (not standalone)
- **State Management**: Angular signals for reactive state
- **Routing**: Angular Router with lazy-loaded modules
- **Server**: Express.js for SSR with hydration and event replay

## Key Files & Structure
- `src/app/app.ts` - Main app component using signals
- `src/app/app-module.ts` - Root module with BrowserModule and hydration providers
- `src/app/app-routing-module.ts` - Routing configuration
- `src/main.server.ts` & `src/server.ts` - SSR setup

## Development Workflow
- **Start dev server**: `npm start` or `ng serve` (runs on http://localhost:4200)
- **Build**: `npm run build` or `ng build` (outputs to `dist/`)
- **SSR serve**: `npm run serve:ssr:mostrarOcultarMensaje` (server-side rendered)
- **Test**: `npm test` or `ng test` (uses Vitest)

## Code Conventions
- **Component prefix**: `app-` (configured in angular.json)
- **File naming**: kebab-case for files, PascalCase for classes
- **Templates**: External HTML files (templateUrl) preferred over inline
- **Styles**: External CSS files (styleUrl) preferred over inline
- **Imports**: Use relative paths within app, absolute for Angular/core

## Angular Patterns
- **Components**: Use `@Component` decorator with selector, templateUrl, styleUrl
- **Signals**: Use `signal()` for reactive state, `computed()` for derived state
- **Modules**: Import feature modules in app-module.ts
- **Hydration**: Enabled with `provideClientHydration(withEventReplay())`

## Schematics Configuration
- **Skip tests**: All generated components/directives/pipes/services skip test files
- **Standalone**: Set to false - use NgModules
- **Example**: `ng generate component my-component` creates module-based component

## Prettier Configuration
- **Print width**: 100 characters
- **Quotes**: Single quotes
- **HTML parser**: Use Angular parser for .html files

## Build Configuration
- **SSR**: Enabled with entry points in main.server.ts
- **Budgets**: 500KB initial, 1MB total; 4KB per component style
- **Optimization**: Hashing enabled in production
- **Source maps**: Enabled in development

## Common Tasks
- **Add component**: `ng generate component components/my-component`
- **Add service**: `ng generate service services/my-service`
- **Add route**: Update app-routing-module.ts with new Routes

## SSR Considerations
- **Server entry**: `src/main.server.ts` bootstraps for server
- **Express server**: `src/server.ts` handles SSR requests
- **Hydration**: Client reuses server-rendered DOM with event replay

## Dependencies
- **Angular 21**: Core framework with signals and SSR
- **RxJS 7.8**: Reactive programming
- **Express 5.1**: Server for SSR
- **TypeScript 5.9**: Type checking and compilation