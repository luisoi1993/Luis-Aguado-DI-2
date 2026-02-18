import { Injectable } from '@angular/core';
import { Libro } from '../model/libro';

@Injectable({
  providedIn: 'root',
})
export class Carrito {
 carrito: Libro[] = [];

  agregar(libro: Libro) {
    this.carrito.push(libro);
  }

  getCarrito(): Libro[] {
    return this.carrito;
  }

  vaciar() {
    this.carrito = [];
  }
}
