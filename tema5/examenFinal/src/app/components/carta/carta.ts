import { Component, Input } from '@angular/core';
import { libro } from '../../model/libro';
import { Router } from '@angular/router';
import { CarritoService } from '../../services/carrito';

@Component({
  selector: 'app-carta',
  templateUrl: './carta.html',
  standalone: false,
  styleUrl: './carta.css',
})
export class Carta {
  @Input() item?: libro;

  constructor(
    private router: Router,
    private carrito: CarritoService
  ) {}

  verDetalle(id: number) {
    this.router.navigate(['detalle', id]);
  }

  agregar() {
    this.carrito.agregar(this.item as libro);
  }
}
