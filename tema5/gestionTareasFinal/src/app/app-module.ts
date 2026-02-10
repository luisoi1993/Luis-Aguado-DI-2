import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { FormsModule } from '@angular/forms';
import { Agregar } from './components/agregar/agregar';
import { Buscar } from './components/buscar/buscar';
import { Mostrar } from './components/mostrar/mostrar';
import { ImagenesPipe } from './pipes/imagenes-pipe';

@NgModule({
  declarations: [
    App,
    Agregar,
    Buscar,
    Mostrar,
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
  ],
  bootstrap: [App]
})
export class AppModule { }
