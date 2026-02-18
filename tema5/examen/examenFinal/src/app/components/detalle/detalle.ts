import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Libro } from '../../model/libro';
import { Libros } from '../../services/libros';

@Component({
  selector: 'app-detalle',
  standalone: false,
  templateUrl: './detalle.html',
  styleUrl: './detalle.css',
})
export class Detalle {
 libro?: Libro;

  constructor(
    private route: ActivatedRoute,
    private servicio: Libros
  ) {
    let id = this.route.snapshot.params['id'];
    this.libro = this.servicio.getLibroById(Number(id));
  }
}
