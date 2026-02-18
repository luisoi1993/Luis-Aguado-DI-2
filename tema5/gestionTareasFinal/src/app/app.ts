import { Component, signal } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
 

 constructor(private gestorRutas: Router) {}
  
  protected readonly title = signal('gestionTareasFinal');
  opcionSeleccionada: string = 'ver-tareas';

  navegar(param: string) {
    //cuando tenga algun procesamiento de datos
    this.gestorRutas.navigate(['buscar', param]);
  }
}
