import { Component } from '@angular/core';

@Component({
  selector: 'app-listadodeproductos',
  standalone: false,
  templateUrl: './listadodeproductos.html',
  styleUrl: './listadodeproductos.css',
})
export class Listadodeproductos {

   protected readonly productos = [
    { nombre: 'Manzana', precio: 1.2, tipo: 'Fruta' },
    { nombre: 'Leche', precio: 2.5, tipo: 'Lácteo' },
    { nombre: 'Pan', precio: 1.8, tipo: 'Cereal' },
    { nombre: 'Carne', precio: 5.0, tipo: 'Proteína' },
    { nombre: 'Arroz', precio: 3.0, tipo: 'Cereal' },
    { nombre: 'Queso', precio: 4.0, tipo: 'Lácteo' }
  ];
}
