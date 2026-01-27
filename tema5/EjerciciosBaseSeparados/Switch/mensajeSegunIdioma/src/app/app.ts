import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('mensajeSegunIdioma');
  //declarar variable para el idioma con una de inicio y luego con mas posibilidades
  idioma: string = 'espanol';
}
