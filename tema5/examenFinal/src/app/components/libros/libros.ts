import { Component, input } from '@angular/core';
import { Libros } from '../../services/libroservicio';
import { libro } from '../../model/libro';

@Component({
  selector: 'app-libros',
  templateUrl: './libros.html',
  standalone: false,
  styleUrl: './libros.css',
})
export class LibrosComponent {
  libros: libro[] = [];

  constructor(private servicio: Libros) {
    this.libros = this.servicio.getLibros();
  }
}

export { Libros };
