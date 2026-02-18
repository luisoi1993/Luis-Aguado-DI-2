import { Component } from '@angular/core';
import { CarritoService } from '../../services/carrito';
import { libro } from '../../model/libro';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.html',
  standalone: false,
  styleUrl: './carrito.css',
})
export class Carrito {
  libros: libro[] = [];

  constructor(private carrito: CarritoService) {
    this.libros = this.carrito.getCarrito();
  }

  comprar() {
    Swal.fire('Compra realizada correctamente');
    this.carrito.vaciar();
    this.libros = [];
  }
}
