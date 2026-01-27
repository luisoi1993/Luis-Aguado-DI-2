# AI Coding Guidelines for mensajeSegunIdioma

## Project Overview
This is an Angular 21 SSR application for displaying messages based on selected language. Uses NgModules architecture with signals for reactive state management.

## Architecture
- **Framework**: Angular 21 with Server-Side Rendering (SSR)
- **Component Style**: NgModules (not standalone components)
- **State Management**: Angular signals for reactive data
- **Forms**: Template-driven forms with FormsModule
- **Routing**: Angular Router configured but routes not yet defined

## Key Files
- `src/app/app.ts`: Main component using signals (e.g., `title = signal('mensajeSegunIdioma')`)
- `src/app/app-module.ts`: Root module importing FormsModule and routing
- `angular.json`: Schematics configured to skip test generation
- `tsconfig.json`: Strict TypeScript with Angular compiler options enabled

## Development Workflow
- **Start dev server**: `npm start` or `ng serve` (runs on http://localhost:4200)
- **Build**: `npm run build` or `ng build` (outputs to `dist/`)
- **SSR serve**: `npm run serve:ssr:mensajeSegunIdioma` for production SSR
- **Watch mode**: `npm run watch` for development builds

## Code Conventions
- **TypeScript**: Strict mode enabled with no implicit returns, strict templates
- **Formatting**: Prettier with single quotes, 100 char width, Angular HTML parser
- **Component Generation**: CLI schematics skip test files by default
- **Imports**: Use relative paths for app-internal modules

## Patterns & Examples
- **Reactive State**: Use signals for component properties (see `app.ts`)
- **Forms**: Import FormsModule in modules for ngModel binding
- **SSR**: App configured for hydration with event replay
- **Styling**: CSS variables for theming in `app.html`

## Dependencies
- Angular 21 core packages
- RxJS for observables
- Express for SSR server
- TypeScript 5.9 with strict settings

Focus on implementing language selection and message display logic in the App component.</content>
<parameter name="filePath">c:\Users\luis\Documents\GitHub\Luis-Aguado-DI-2\tema5\mensajeSegunIdioma\.github\copilot-instructions.md