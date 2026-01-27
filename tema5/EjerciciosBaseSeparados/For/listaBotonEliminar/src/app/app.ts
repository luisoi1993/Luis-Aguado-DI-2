import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('listaBotonEliminar');

   tareas: string[] = [
    'Estudiar Angular',
    'Hacer ejercicios',
    'Repasar ngFor'
  ];

  eliminarTarea(index: number) {
    this.tareas.splice(index, 1);
  }

}
