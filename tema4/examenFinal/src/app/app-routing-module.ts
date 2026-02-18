import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
 
  //{ path: 'buscar', component: Buscar },
 // { path: 'buscar/:id', component: Buscar },
//  { path: 'detalle/:id', component: Detail },
 // { path: '**', pathMatch: 'full', redirectTo: 'agregar' },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
