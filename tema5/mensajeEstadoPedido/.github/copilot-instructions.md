# AI Coding Guidelines for MensajeEstadoPedido

## Project Overview
This is an Angular 21 application for displaying order status messages ("Mensaje Estado Pedido"). It uses server-side rendering (SSR) and follows Angular's module-based architecture.

## Architecture Patterns
- **Component Structure**: Use NgModules with `standalone: false` (configured in `angular.json`)
- **State Management**: Prefer Angular signals for reactive state in components
- **Routing**: Implement routes in `AppRoutingModule` with lazy-loaded modules
- **SSR**: Leverage Angular Universal for server-side rendering; test with `npm run serve:ssr`

## Code Conventions
- **Formatting**: Use Prettier with `printWidth: 100`, `singleQuote: true`, and Angular parser for HTML templates
- **File Naming**: Follow Angular CLI defaults (e.g., `component-name.component.ts`)
- **Imports**: Organize imports with Angular core first, then third-party, then local

## Development Workflow
- **Serve**: `ng serve` for development (auto-reloads)
- **Build**: `ng build` for production (outputs to `dist/`)
- **SSR Build**: Use `ng build` with SSR configuration for server-side rendering
- **Testing**: No unit tests configured (schematics skip tests); add manually if needed using Vitest

## Key Files
- `src/app/app.ts`: Main component using signals
- `src/app/app-module.ts`: Root module with SSR providers
- `angular.json`: Build config with SSR and module schematics
- `package.json`: Scripts for serve, build, and SSR

## Best Practices
- Keep components simple; use services for business logic
- Use Angular forms for user input
- Implement error handling with global error listeners
- Follow Angular's change detection with signals for performance