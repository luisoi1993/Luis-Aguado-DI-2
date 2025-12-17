class tarea {
  nombre;
  fecha;
  prioridad;

  constructor(nombre, fecha, prioridad) {
    this.nombre = nombre;
    this.fecha = fecha;
    this.prioridad = prioridad;
  }

  mostrarDatos() {
    console.log(`Nombre: ${this.nombre} - Fecha: ${this.fecha} - Prioridad: ${this.prioridad}`);
  }

  get getNombre() {
    return this.nombre;
  }

  set setNombre(nombre) {
    this.nombre = nombre;
  }
}

// PRUEBAS
let tareaPrueba = new tarea("Tarea1", new Date(), "Alta");
tareaPrueba.setNombre = "Tarea Muy Prioritaria";
console.log(tareaPrueba.getNombre);
tareaPrueba.mostrarDatos();
