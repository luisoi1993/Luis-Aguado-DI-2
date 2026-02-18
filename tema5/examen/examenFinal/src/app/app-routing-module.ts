import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Carritoc } from './components/carritoc/carritoc';
import { Detalle } from './components/detalle/detalle';
import { Libros, Librosc } from './components/librosc/librosc';


const routes: Routes = [
// { path: 'libros', component: Librosc },
 // { path: 'carrito', component: Carritoc },
 // { path: 'detalle/:id', component: Detalle },
 // { path: '**', pathMatch: 'full', redirectTo: 'libros' },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
