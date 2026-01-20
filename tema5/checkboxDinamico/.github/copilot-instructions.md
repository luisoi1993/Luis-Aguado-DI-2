# AI Coding Guidelines for CheckboxDinamico

## Architecture Overview
- **Framework**: Angular 21 with Server-Side Rendering (SSR) and prerendering enabled.
- **Module System**: Uses NgModules (not standalone components). All components must be declared in modules.
- **Routing**: Basic setup with empty routes in `app-routing-module.ts`. Extend `routes: Routes` array for new pages.
- **Forms**: Relies on template-driven forms with `ngModel`. Always import `FormsModule` in the relevant NgModule (e.g., `AppModule` in `app-module.ts`).
- **Data Binding**: Prefer Angular signals for reactive component properties, as seen in `app.ts` with `title = signal('checkboxDinamico')`.

## Key Files and Structure
- **Main Component**: `src/app/app.ts` - Root component with template `app.html` and styles `app.css`.
- **Modules**: `app-module.ts` (main), `app-routing-module.ts` (routing), `app.module.server.ts` (SSR).
- **Configuration**: `angular.json` sets schematics to skip tests and use non-standalone components.
- **Styling**: Global styles in `src/styles.css`; component styles in separate `.css` files.

## Developer Workflows
- **Start Dev Server**: `npm start` or `ng serve` - Runs on `http://localhost:4200` with auto-reload.
- **Build**: `npm run build` or `ng build` - Outputs to `dist/`; use `--configuration development` for dev builds.
- **Test**: `npm test` or `ng test` - Uses Vitest runner.
- **SSR Serve**: `npm run serve:ssr:checkboxDinamico` - Runs the SSR build locally.
- **Watch Mode**: `npm run watch` - Builds with watch for development.

## Conventions and Patterns
- **File Naming**: Use kebab-case for module files (e.g., `app-module.ts`, `app-routing-module.ts`) to distinguish from components.
- **Component Declaration**: Always set `standalone: false` in `@Component` decorators.
- **Code Style**: Enforced by Prettier with `printWidth: 100`, `singleQuote: true`, and Angular parser for `.html` files.
- **Error Handling**: No custom patterns yet; follow Angular best practices for SSR hydration.
- **Dependencies**: Minimal; add to `package.json` and import in modules as needed.

## Common Pitfalls
- Ensure `FormsModule` is imported in `AppModule` for `ngModel` to work in templates.
- Component properties referenced in templates (e.g., `name`, `age` in `app.html`) must be declared in the component class.
- SSR requires careful handling of browser-only APIs; use `isPlatformBrowser` guards if needed.

## Integration Points
- **External APIs**: None currently; add HTTP services via `HttpClientModule` if integrating REST APIs.
- **Build Output**: SSR builds include server bundle in `dist/checkboxDinamico/server/`.
- **Deployment**: Prerendered for static hosting; use `ng build` for production.</content>
<parameter name="filePath">c:\Users\luis\Documents\GitHub\Luis-Aguado-DI-2\tema5\checkboxDinamico\.github\copilot-instructions.md