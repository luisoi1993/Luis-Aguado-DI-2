import { Component } from '@angular/core';

@Component({
  selector: 'app-mensajerol',
  standalone: false,
  templateUrl: './mensajerol.html',
  styleUrl: './mensajerol.css',
})
export class Mensajerol {
  rol: string = 'admin'; // 'admin' | 'editor' | 'invitado'
}
