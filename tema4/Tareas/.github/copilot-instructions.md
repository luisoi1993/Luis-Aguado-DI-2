# Copilot / AI agent instructions

Propósito breve
- Ayudar a contribuir en este pequeño proyecto estático (HTML + JS) con pasos específicos y ejemplos detectables en el código.

Visión general (big picture)
- Proyecto: sitio estático simple. Entrada principal: [index.html](index.html#L1-L400).
- Dependencias externas cargadas por CDN: Bootstrap, SweetAlert2 y Animate.css (en el `<head>`).
- Código JS: `./utils/index.js` (incluido como un script normal al final del `body`). Actualmente está vacío; es el punto de inserción para la lógica DOM.

Flujos y límites de responsabilidad
- `index.html`: estructura y referencias a librerías externas; contiene el botón con clases `btn btn-danger` que sirve como ejemplo de objetivo para eventos.
- `utils/index.js`: encapsula comportamiento de la UI (manejadores de eventos, llamadas a SweetAlert2, manipulación del DOM). No hay servidor ni API remota en el repo.

Convenciones relevantes (detectables)
- Scripts: se incluyen sin `type="module"` (script global). Mantén compatibilidad con carga global (uso de `document` global). Evita transformar a módulos a menos que actualices `index.html`.
- Inicialización: envuelve la lógica en `document.addEventListener('DOMContentLoaded', ...)` o en un IIFE para no contaminar el scope global.
- UI: usa clases Bootstrap ya presentes; usa SweetAlert2 para diálogos (ya cargado vía CDN).

Ejemplos concretos (copiar/pegar)
- Agregar un manejador para el botón `.btn.btn-danger` en `utils/index.js`:

```js
document.addEventListener('DOMContentLoaded', () => {
  const btn = document.querySelector('.btn.btn-danger');
  if (!btn) return;
  btn.textContent = 'Eliminar';
  # Copilot / AI agent instructions

  Propósito breve
  - Ayudar a contribuir rápidamente en esta pequeña colección de sitios estáticos (HTML + JS) aportando patrones concretos y ejemplos reproducibles.

  Resumen del repositorio
  - Estructura principal: carpetas `Tareas/` y `Promesas/` (cada una contiene un `index.html` y `utils/`).
  - Dependencias: Bootstrap, SweetAlert2 y Animate.css cargadas por CDN desde los `index.html`.

  Responsabilidades por archivo
  - `Tareas/index.html`, `Promesas/index.html`: markup y referencias a CDNs.
  - `Tareas/utils/index.js`, `Promesas/utils/index.js`: punto de entrada para la lógica DOM. `Tareas/utils/tarea.js` contiene helpers.

  Reglas y convenciones detectables
  - Scripts se cargan como globales (no `type="module"`). No conviertas a módulos sin actualizar los `index.html` y coordinar cambios.
  - Inicializa la UI con `document.addEventListener('DOMContentLoaded', ...)` o un IIFE para evitar leaks globales.
  - Usa las clases Bootstrap ya presentes y `Swal.fire()` para diálogos; SweetAlert2 está disponible globalmente.
  - Evita cambios estructurales (añadir bundler, package.json, o módulos) a menos que se documente y coordine.

  Ejemplo práctico (copiar/pegar)
  En `Tareas/utils/index.js`:

  ```js
  document.addEventListener('DOMContentLoaded', () => {
    const btn = document.querySelector('.btn.btn-danger');
    if (!btn) return;
    btn.textContent = 'Eliminar';
    btn.addEventListener('click', () => {
      Swal.fire({ title: 'Confirmar', text: '¿Deseas continuar?' });
    });
  });
  ```

  Flujos de trabajo y comandos útiles
  - Previsualización rápida: abrir `index.html` en el navegador o usar Live Server en VS Code.
  - Servidor estático desde la raíz del workspace:

  ```bash
  npx http-server . -p 8000
  # o
  python -m http.server 8000
  ```

  Testing y lint
  - No hay tests ni configuración de linter detectados. Verifica manualmente los cambios en navegador.

  Edición y PRs
  - Haz cambios atómicos por archivo. Edita `utils/index.js` o `utils/tarea.js` para lógica JS; toca `index.html` solo si es estrictamente necesario.
  - Mensajes sugeridos: `feat(ui): ...` o `fix(js): ...` e incluye los archivos modificados.

  Notas finales
  - Las librerías dependen de CDNs; trabajar offline puede romper la UI.
  - Si necesitas introducir módulos, bundlers o tests, solicita permiso y documenta los cambios aquí antes de implementarlos.

  Feedback
  - Si falta algo o quieres ejemplos adicionales (eventos, manipulación DOM, o tests), indícame qué ampliar.
