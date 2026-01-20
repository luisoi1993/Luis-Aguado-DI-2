**Resumen del proyecto**

- **Tipo:** Aplicación Angular con soporte SSR (Angular Universal).
- **Entradas cliente/servidor:** [src/main.ts](src/main.ts) (cliente), [src/main.server.ts](src/main.server.ts) (bundle server), [src/server.ts](src/server.ts) (Express + AngularNodeAppEngine).
- **Angular versión:** v21.x (ver `package.json`).

**Cómo ejecutar y probar**

- **Desarrollo local:** `npm start` (ejecuta `ng serve`).
- **Build producción:** `npm run build` y luego `npm run serve:ssr:inicial` para servir el bundle SSR (`node dist/inicial/server/server.mjs`).
- **Tests unitarios:** `npm test` (usa `ng test` / Vitest según la configuración).

**Patrones y convenciones del repo**

- **SSR / servidor:** El servidor Express se define en [src/server.ts](src/server.ts). Usa `@angular/ssr/node` y `AngularNodeAppEngine` para renderizar. Evita tocar la lógica Express sin revisar `createNodeRequestHandler` y `writeResponseToNodeResponse`.
- **Rutas y pre-rendering:** Las rutas del servidor están en [src/app/app.routes.server.ts](src/app/app.routes.server.ts) usando `RenderMode.Prerender`. Si añades rutas, actualiza ese archivo y confirma el modo de renderizado.
- **Módulos cliente/servidor:** El módulo cliente principal está en [src/app/app-module.ts](src/app/app-module.ts). El bundle server exporta `AppServerModule` desde [src/main.server.ts](src/main.server.ts) hacia `src/app/app.module.server.ts` — cuando añadas providers o componentes compartidos, actualiza ambos módulos según corresponda.
- **Hidratación cliente:** `app-module.ts` ya utiliza `provideClientHydration(withEventReplay())`. Mantén la compatibilidad al introducir eventos o side-effects en componentes.

**Reglas para el agente (prácticas específicas)**

- Antes de cambiar UI o rutas, buscar y editar ambas entradas: [src/main.ts](src/main.ts) / [src/main.server.ts](src/main.server.ts) y los módulos `app.module` / `app.module.server` si aplica.
- Para cambios en el servidor (API o middleware), revisar `src/server.ts` y respetar el manejo de archivos estáticos (`browserDistFolder`) y el `reqHandler` usado por Angular CLI/SSR.
- Al agregar paquetes, preferir versiones compatibles con TypeScript ~5.9 y Angular 21 (ver `devDependencies`).
- Para añadir tests, seguir la infraestructura existente (`app.spec.ts`, `tsconfig.spec.json`) y preferir pruebas unitarias sobre Vitest (`npm test`).

**Archivos clave**

- **Configuración y scripts:** [package.json](package.json)
- **Servidor Express + SSR:** [src/server.ts](src/server.ts)
- **Bootstrap cliente:** [src/main.ts](src/main.ts)
- **Bootstrap server:** [src/main.server.ts](src/main.server.ts)
- **Rutas SSR:** [src/app/app.routes.server.ts](src/app/app.routes.server.ts)
- **Módulo principal:** [src/app/app-module.ts](src/app/app-module.ts)

**Qué evitar automáticamente**

- No remover `provideClientHydration` sin validar la experiencia de hidración.
- No eliminar la lógica de `AngularNodeAppEngine` ni reemplazar el `reqHandler` sin probar SSR completo (build + serve:ssr).

**Si necesitas más contexto**

- Pídeme que inspeccione cualquier componente, módulo o script de `package.json` específico y generar snippets o PRs pequeños. También puedo ejecutar los comandos `npm start` / `npm run build` en tu entorno si lo deseas.

---
Si quieres, integro ejemplos concretos de cambios (p. ej. agregar una ruta y su test) en un PR. ¿Qué área quieres priorizar?
