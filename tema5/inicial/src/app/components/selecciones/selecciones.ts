import { Component } from '@angular/core';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-selecciones',
  standalone: false,
  templateUrl: './selecciones.html',
  styleUrl: './selecciones.css',
})
export class Selecciones {

    seleccion = '1';

    comprador = {
    nombre: '',
    direccionEnvio: '',
    direccionFacturacion: '',
    coste: null as number | null,
    tipoPago: '',
    telefono: '',
    tarjeta: null as number | null,
    cuenta: ''
  };


   

     guardarCandidato() {
    const { nombre, direccionEnvio, direccionFacturacion, coste, tipoPago } = this.comprador;

   
    console.log('Candidato evaluado:', this.comprador);

   this.alerta();
    
  }

  alerta() {
    switch(this.comprador.tipoPago) {
      case 'bizum':
        alert("Compra validada correctamente el telefono es ${this.comprador.telefono}");
        break;
      case 'pagoOrdinario':
        alert("Compra validada correctamente la tarjeta es ${this.comprador.tarjeta}");
        break;
      case 'trasferencia':
        alert("Compra validada correctamente la cuenta es ${this.comprador.cuenta}");
        break;
    }
  }

}
