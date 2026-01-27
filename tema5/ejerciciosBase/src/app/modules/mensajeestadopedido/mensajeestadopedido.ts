import { Component } from '@angular/core';

@Component({
  selector: 'app-mensajeestadopedido',
  standalone: false,
  templateUrl: './mensajeestadopedido.html',
  styleUrl: './mensajeestadopedido.css',
})
export class Mensajeestadopedido {
  estadoPedido : string = 'pendiente' // 'pendiente', 'enviado', 'entregado';
}
