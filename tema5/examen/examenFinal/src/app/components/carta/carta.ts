import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Carrito } from '../../services/carrito';
import { Libro } from '../../model/libro';

@Component({
  selector: 'app-carta',
  standalone: false,
  templateUrl: './carta.html',
  styleUrl: './carta.css',
})
export class Carta {
 @Input() item?: Libro;

  constructor(
    private router: Router,
    private carrito: Carrito
  ) {}

  verDetalle(id: number) {
    this.router.navigate(['detalle', id]);
  }

  agregar() {
    this.carrito.agregar(this.item as Libro);
  }
}
