let boton = document.querySelector("#btnAgregar");
let parrafo = document.querySelector("#contenido");
let botonFiltrar = document.querySelector("#btnFiltrar");
//crear array de tareas
let tareas = [];
boton.addEventListener("click", () => {
 //crear tarea y meterla en el ul
   let nombreTarea = document.querySelector("#txtNombre").value;
    let prioridadTarea = document.querySelector("#selPrioridad").value;
    let fechaTarea = new Date(document.querySelector("#dtFecha").value);
    if (nombreTarea === "" || isNaN(fechaTarea.getTime()) || prioridadTarea === "") {
      alert("Por favor, complete todos los campos correctamente.");
      return;
    }
    let nuevaTarea = new tarea(nombreTarea, fechaTarea, prioridadTarea);
    tareas.push(nuevaTarea);
    console.log(tareas);
    let listaTareas = document.querySelector("#listaTareas");
    let nodoTarea = crearNodo("li", `${nuevaTarea.nombre}`, "tarea-item", undefined);
    listaTareas.appendChild(nodoTarea);
    limparCampos();
});
//meter esta carta en el html
/*<div class="card" style="width: 18rem;">
  <img src="..." class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>*/ 

botonFiltrar.addEventListener("click", () => {
  const contenedor = document.querySelector("#listaFiltrada");
  contenedor.innerHTML = "";

  const prioridadFiltro = document.querySelector("#selectFiltrarPrioridad").value;

  const tareasFiltradas = prioridadFiltro === "all"
    ? tareas
    : tareas.filter(t => t.prioridad === prioridadFiltro);

  tareasFiltradas.forEach((tarea) => {

    const col = document.createElement("div");
    col.className = "col-md-4 mb-4 animate__animated animate__fadeInUp";

    const color = getColorPrioridad(tarea.prioridad);

    col.innerHTML = `
      <div class="card shadow h-100 border-${color}">
        
        <img src="${getImagenPrioridad(tarea.prioridad)}"
             class="icono-prioridad animate__animated animate__bounceIn"
             alt="prioridad">

        <div class="card-body pt-5">
          <h5 class="card-title">${tarea.nombre}</h5>
          <p class="card-text">
            📅 ${tarea.fecha.toLocaleDateString()} <br>
            ⚠️ Prioridad: <strong>${getTextoPrioridad(tarea.prioridad)}</strong>
          </p>

          <span class="badge bg-${color}">
            ${getTextoPrioridad(tarea.prioridad)}
          </span>
        </div>
      </div>
    `;

    contenedor.appendChild(col);
  });
});




function crearNodo(tipo, texto, clases, funcion) {
  let nodo = document.createElement(tipo); // CORRECTO

  nodo.innerText = texto;

  if (funcion != undefined) {
    nodo.addEventListener("click", funcion);
  }

  nodo.className = clases;

  return nodo;
}

function limparCampos() {
  document.querySelector("#txtNombre").value = "";
  document.querySelector("#dtFecha").value = "";

} 

function getTextoPrioridad(valor) {
  switch (valor) {
    case "0": return "Baja";
    case "1": return "Media";
    case "2": return "Alta";
    default: return "";
  }
}

function getColorPrioridad(valor) {
  switch (valor) {
    case "0": return "success"; // verde
    case "1": return "warning"; // amarillo
    case "2": return "danger";  // rojo
    default: return "secondary";
  }
}

function getImagenPrioridad(valor) {
  switch (valor) {
    case "0": return "./img/baja.png";
    case "1": return "./img/media.png";
    case "2": return "./img/alta.png";
    default: return "";
  }
}
