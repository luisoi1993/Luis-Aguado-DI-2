import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ImagenesPipe } from './pipes/imagenes-pipe';
import { Carta } from './components/carta/carta';
import { Librosc } from './components/librosc/librosc';
import { Carritoc } from './components/carritoc/carritoc';
import { Detalle } from './components/detalle/detalle';

@NgModule({
  declarations: [
    App,
    ImagenesPipe,
    Carta,
    Librosc,
    Carritoc,
    Detalle
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideClientHydration(withEventReplay()),
  ],
  bootstrap: [App]
})
export class AppModule { }
