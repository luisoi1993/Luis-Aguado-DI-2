import { Component } from '@angular/core';

@Component({
  selector: 'app-mensajesegunidioma',
  standalone: false,
  templateUrl: './mensajesegunidioma.html',
  styleUrl: './mensajesegunidioma.css',
})
export class Mensajesegunidioma {
   //declarar variable para el idioma con una de inicio y luego con mas posibilidades
  idioma: string = 'espanol';
}
