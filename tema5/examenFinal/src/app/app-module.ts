import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { FormsModule } from '@angular/forms';
import { Libros } from './components/libros/libros';
import { Carta } from './components/carta/carta';
import { Carrito } from './components/carrito/carrito';
import { Detalle } from './components/detalle/detalle';
import { ImagenesPipe } from './pipes/imagenes-pipe';

@NgModule({
  //importar el servicio de libros para que esté disponible en toda la aplicación
  declarations: [
    App,
    Libros,
    Carta,
    Carrito,
    Detalle,
    ImagenesPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideClientHydration(withEventReplay()),
    Libros
  ],
  bootstrap: [App]
})
export class AppModule { }
