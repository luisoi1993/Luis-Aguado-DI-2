import { Component, signal } from '@angular/core';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('inicial');
  nombre: string = "Borja";
  apellido: string = "Martin Herrera";
  curso:number = 2;
  nombreCurso: string = "Desarrollo de Aplicaciones Multiplataforma";
  nota:number | string = 0;

  pulsarComenzar(nota: string){
    //escribir el mensaje y que ponga la nota introducida en el input
    this.nota = nota;
    if(isNaN(Number(nota)) || nota === ""){
      this.nota = "No has introducido una nota válida";
    } else {
      this.nota = Number(nota);
    }

    Swal.fire({
  title: 'Error!',
  text: 'Do you want to continue',
  icon: 'error',
  confirmButtonText: 'Cool'
})
  }
}
