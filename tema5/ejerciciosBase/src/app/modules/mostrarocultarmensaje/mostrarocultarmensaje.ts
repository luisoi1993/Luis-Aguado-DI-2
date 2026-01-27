import { Component } from '@angular/core';

@Component({
  selector: 'app-mostrarocultarmensaje',
  standalone: false,
  templateUrl: './mostrarocultarmensaje.html',
  styleUrl: './mostrarocultarmensaje.css',
})
export class Mostrarocultarmensaje {
   mostrarMensaje: boolean = false;

  toggleMensaje() {
    this.mostrarMensaje = !this.mostrarMensaje;
  }
}
