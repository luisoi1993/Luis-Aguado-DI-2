import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Libros } from './components/libros/libros';
import { Carrito } from './components/carrito/carrito';
import { Detalle } from './components/detalle/detalle';

const routes: Routes = [
  { path: 'libros', component: Libros },
  { path: 'carrito', component: Carrito },
  { path: 'detalle/:id', component: Detalle },
  { path: '**', pathMatch: 'full', redirectTo: 'libros' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
