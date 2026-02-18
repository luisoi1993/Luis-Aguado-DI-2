import { Component } from '@angular/core';
import { Libro } from '../../model/libro';
import { Carrito } from '../../services/carrito';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-carritoc',
  standalone: false,
  templateUrl: './carritoc.html',
  styleUrl: './carritoc.css',
})
export class Carritoc {
 libros: Libro[] = [];

  constructor(private carrito: Carrito) {
    this.libros = this.carrito.getCarrito();
  }

  comprar() {
    Swal.fire('Compra realizada correctamente');
    this.carrito.vaciar();
    this.libros = [];
  }
}
