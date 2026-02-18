import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Agregar } from './components/agregar/agregar';
import { Buscar } from './components/buscar/buscar';
import { Mostrar } from './components/mostrar/mostrar';

const routes: Routes = [
  {path:'agregar', component: Agregar},
  {path:'agregar/:id', component: Agregar},
  {path:'buscar',component: Buscar},
  {path: 'mostrar', component: Mostrar},
  {path:'**', redirectTo:'agregar', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
