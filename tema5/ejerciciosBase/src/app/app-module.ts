import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { FormsModule } from '@angular/forms';
import { Mensajerol } from './modules/mensajerol/mensajerol';
import { Mostrarocultarmensaje } from './modules/mostrarocultarmensaje/mostrarocultarmensaje';
import { Validaciondeedad } from './modules/validaciondeedad/validaciondeedad';
import { Checkboxdinamico } from './modules/checkboxdinamico/checkboxdinamico';
import { Formulariodeusuario } from './modules/formulariodeusuario/formulariodeusuario';
import { Selectordeopciones } from './modules/selectordeopciones/selectordeopciones';
import { Iconodinamico } from './modules/iconodinamico/iconodinamico';
import { Mensajeestadopedido } from './modules/mensajeestadopedido/mensajeestadopedido';
import { Mensajesegunidioma } from './modules/mensajesegunidioma/mensajesegunidioma';
import { Listabotoneliminar } from './modules/listabotoneliminar/listabotoneliminar';
import { Listadodeproductos } from './modules/listadodeproductos/listadodeproductos';
import { Numerarunalista } from './modules/numerarunalista/numerarunalista';

@NgModule({
  declarations: [
    App,
    Mensajerol,
    Mostrarocultarmensaje,
    Validaciondeedad,
    Checkboxdinamico,
    Formulariodeusuario,
    Selectordeopciones,
    Iconodinamico,
    Mensajeestadopedido,
    Mensajesegunidioma,
    Listabotoneliminar,
    Listadodeproductos,
    Numerarunalista
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideClientHydration(withEventReplay()),
  ],
  bootstrap: [App]
})
export class AppModule { }
