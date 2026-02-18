import { Injectable } from '@angular/core';
import { libro } from '../model/libro';

@Injectable({
  providedIn: 'root',
})
export class CarritoService {
  carrito: libro[] = [];

  agregar(libro: libro) {
    this.carrito.push(libro);
  }

  getCarrito(): libro[] {
    return this.carrito;
  }

  vaciar() {
    this.carrito = [];
  }
}
