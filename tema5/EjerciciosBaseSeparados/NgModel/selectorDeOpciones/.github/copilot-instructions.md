# AI Coding Guidelines for SelectorDeOpciones

## Project Overview
This is an Angular 21 application using NgModule-based architecture with Server-Side Rendering (SSR) and prerendering enabled. The app follows strict TypeScript configurations and uses Angular CLI for scaffolding.

## Architecture Patterns
- **Component Structure**: Use NgModule-based components (not standalone). Components are declared in modules like `AppModule`.
- **Routing**: Routes are defined in `AppRoutingModule` using `RouterModule.forRoot(routes)`.
- **SSR Setup**: Server-side rendering is configured with prerendering for all routes (`**` path). Use `AppServerModule` for server bootstrap.
- **State Management**: Currently uses Angular signals for reactive state (e.g., `signal('selectorDeOpciones')` in App component).

## Development Workflows
- **Start Dev Server**: `ng serve` (serves on http://localhost:4200 with auto-reload)
- **Build**: `ng build` (outputs to `dist/` with production optimizations)
- **SSR Serve**: `npm run serve:ssr:selectorDeOpciones` (serves prerendered app)
- **Testing**: `ng test` (uses Vitest runner)
- **Watch Mode**: `npm run watch` (builds on changes)

## Code Generation Conventions
- **Schematics**: All generated items skip tests (`skipTests: true`)
- **Standalone**: Components, directives, pipes are not standalone (`standalone: false`)
- **Prefix**: Use `app-` prefix for selectors
- **File Naming**: Follow Angular CLI defaults (e.g., `component-name.component.ts`)

## Configuration
- **TypeScript**: Strict mode enabled with additional checks (noImplicitOverride, noPropertyAccessFromIndexSignature, etc.)
- **Prettier**: printWidth: 100, singleQuote: true, Angular parser for HTML files
- **Angular Compiler**: Strict templates and injection parameters

## Key Files
- `src/app/app-module.ts`: Main app module with hydration providers
- `src/app/app-routing-module.ts`: Route configuration
- `src/app/app.routes.server.ts`: SSR route rendering modes
- `angular.json`: Build config with SSR options and schematics settings

## Patterns to Follow
- Use `provideClientHydration(withEventReplay())` for hydration
- Import modules in `AppModule` for non-standalone components
- Define routes as `const routes: Routes = []` in routing modules</content>
<parameter name="filePath">c:\Users\luis\Documents\GitHub\Luis-Aguado-DI-2\tema5\selectorDeOpciones\.github\copilot-instructions.md