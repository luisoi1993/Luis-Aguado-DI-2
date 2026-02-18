import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Libros } from '../../services/libroservicio';
import { libro } from '../../model/libro';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.html',
  standalone: false,
  styleUrl: './detalle.css',
})
export class Detalle {
  libro?: libro;

  constructor(
    private route: ActivatedRoute,
    private servicio: Libros
  ) {
    let id = this.route.snapshot.params['id'];
    this.libro = this.servicio.getLibroById(Number(id));
  }
}
