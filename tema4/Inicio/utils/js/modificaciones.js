/*
let botonAgregar = document.querySelector("#boton-agregar");
let botones = document.querySelectorAll(".boton");
console.log(botonAgregar);

botonAgregar.addEventListener("click", (ev) => {
console.log("boton pulsado");
console.log(ev);


})
*/
let nombre = document.querySelector("#inputNombre");


let apellido = document.querySelector("#inputApellido");

let fecha = document.querySelector("#inputFecha");

let botonEnviar = document.querySelector("#btnAgregar");

let botonLimpiar = document.querySelector("#btnLimpiar");

let listaAgregados = document.querySelector("#listaAgregados ul");

botonLimpiar.addEventListener("click", (ev) => {  
    limpiarCampos(nombre, apellido, fecha);
});  

botonEnviar.addEventListener("click", (ev) => {
    if(nombre.value === "" || apellido.value === "" || fecha.value === ""){
       lanzarDialogo("Error", "Por favor, rellena todos los campos", "warning");
        return;
    }
   // agregarLi(nombre.value, apellido.value, fecha.value);
   crearNodo("li", {class: "list-group-item"}, `${nombre.value} ${apellido.value} - ${fecha.value}`);
   crearNodo("button", {class: "btn btn-danger btn-sm btn-eliminar"}, "eliminar", listaAgregados.lastChild);
   let botonEliminar = listaAgregados.lastChild.querySelector(".btn-eliminar");
    limpiarCampos(nombre, apellido, fecha);
})

/*
btnEliminar.addEventListener("click", (ev) => {  
    eliminarTodo();
});
*/

btn-eliminar.addEventListener("click", (ev) => {  
    eliminarTodo();
});

function lanzarDialogo(title, text, icon) {
    Swal.fire({
  title: title,
  text: text,
  icon: icon,
});
}

function agregarLi(nombre, apellido, fecha) {
   //  lanzarDialogo("Formulario enviado", "Gracias por enviar el formulario", "success");
   /*
    listaAgregados.innerHTML += `<li class="list-group-item d-flex justify-content-between align-items-start animate__animated animate__fadeInTopRight">
            ${nombre} ${apellido} - ${fecha}
            <button class="btn btn-danger btn-sm btn-eliminar">eliminar</button>
          </li>`;
    let botonEliminar = li.querySelector(".btn-eliminar");

    */
    let li = document.createElement("li");
    li.classList.add("list-group-item", "d-flex", "justify-content-between", "align-items-start", "animate__animated", "animate__fadeInTopRight");
    li.innerHTML = `${nombre} ${apellido} - ${fecha} <button class="btn btn-danger btn-sm btn-eliminar">eliminar</button>`;
    listaAgregados.appendChild(li);
    let botonEliminar = li.querySelector(".btn-eliminar");
    botonEliminar.addEventListener("click", (ev) => {
        eliminarLi(botonEliminar);
    });
}

function limpiarCampos() {
   for(let index = 0; index < arguments.length; index++) {
        arguments[index].value = "";
   }
}

function eliminarLi(boton) {
    let li = boton.parentElement;
    li.classList.remove("animate__fadeInTopRight");
    li.classList.add("animate__fadeOutTopRight");   
    li.addEventListener("animationend", () => {
        li.remove();
    });
}

function eliminarTodo() {
    let elementos = listaAgregados.querySelectorAll("li");
    elementos.forEach((li) => {
        li.classList.remove("animate__fadeInTopRight");
        li.classList.add("animate__fadeOutTopRight");
        li.addEventListener("animationend", () => {
            li.remove();
        });
    });
}

//funcion para crear cualquier nodo con atributos y contenido
function crearNodo(tipo, atributos = {}, contenido = "",donde = listaAgregados) {
    let nodo = document.createElement(tipo);
    for (let key in atributos) {
        nodo.setAttribute(key, atributos[key]);
    }
    nodo.textContent = contenido;
    donde.appendChild(nodo);
    return nodo;
}