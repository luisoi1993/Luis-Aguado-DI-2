# AI Coding Guidelines for listadoDeProductos

## Architecture Overview
- **Angular 21 application** with Server-Side Rendering (SSR) and prerendering enabled for all routes (`src/app/app.routes.server.ts`)
- **Module-based components**: Use `standalone: false` for components, directives, and pipes (configured in `angular.json` schematics)
- **App prefix**: All selectors use `app-` prefix (e.g., `selector: 'app-root'` in `src/app/app.ts`)
- **Signal-based state**: Prefer Angular signals for reactive state (e.g., `protected readonly title = signal('listadoDeProductos')` in `src/app/app.ts`)

## Development Workflow
- **Serve locally**: `npm start` (runs `ng serve`)
- **Build**: `npm run build` (produces SSR-compatible output in `dist/`)
- **SSR testing**: `npm run serve:ssr:listadoDeProductos` to test server-rendered version
- **No tests generated**: Schematics configured to skip test files (`skipTests: true` in `angular.json`)

## Code Style & Conventions
- **TypeScript strict mode**: Enabled with additional checks (`noImplicitOverride`, `noPropertyAccessFromIndexSignature`, etc. in `tsconfig.json`)
- **Angular strict templates**: `strictTemplates: true` enforces type-safe templates
- **Prettier formatting**:
  - Line width: 100 characters
  - Single quotes for strings
  - Angular parser for HTML files (configured in `package.json`)
- **Bundle budgets**: Initial bundle ≤500KB (warning), ≤1MB (error); component styles ≤4KB (warning), ≤8KB (error)

## Key Files
- `src/app/app-module.ts`: Main app module with hydration providers (`provideClientHydration(withEventReplay())`)
- `src/app/app-routing-module.ts`: Routing module (currently empty routes)
- `angular.json`: Build config with SSR settings and schematics preferences
- `tsconfig.json`: Strict TypeScript and Angular compiler options

## SSR Considerations
- Prerender all routes by default (`RenderMode.Prerender` in `src/app/app.routes.server.ts`)
- Server module imports client module with route-based rendering (`src/app/app.module.server.ts`)