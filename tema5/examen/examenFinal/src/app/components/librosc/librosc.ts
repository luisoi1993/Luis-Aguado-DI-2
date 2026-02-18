import { Component } from '@angular/core';
import { Libro } from '../../model/libro';
import { Libros } from '../../services/libros';

@Component({
  selector: 'app-librosc',
  standalone: false,
  templateUrl: './librosc.html',
  styleUrl: './librosc.css',
})
export class Librosc {
libros: Libro[] = [];

  constructor(private servicio: Libros) {
    this.libros = this.servicio.getLibros();
  }
}

export { Libros };
