import { Component } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-selecciones',
  standalone: false,
  templateUrl: './selecciones.html',
  styleUrl: './selecciones.css', // 👈 lo dejamos como lo tienes, porque así te funciona
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
    tarjeta: '',
    caducidad: '',
    cvv: '',
    cuenta: ''
  };

  guardarCandidato() {
    console.log('Compra evaluada:', this.comprador);
    this.alerta();
  }

  alerta() {
    let costeFinal = this.comprador.coste ?? 0;
    let datosPago = '';

    // +5% si es transferencia
    if (this.comprador.tipoPago === 'trasferencia') {
      costeFinal = costeFinal * 1.05;
    }

    switch (this.comprador.tipoPago) {

      case 'bizum':
        datosPago = `Bizum (Teléfono: ${this.comprador.telefono})`;
        break;

      case 'pagoOrdinario':
        datosPago = `
          Tarjeta: ${this.comprador.tarjeta}<br>
          Caducidad: ${this.comprador.caducidad}<br>
          CVV: ${this.comprador.cvv}
        `;
        break;

      case 'trasferencia':
        datosPago = `Cuenta: ${this.comprador.cuenta}`;
        break;
    }

    Swal.fire({
      icon: 'success',
      title: 'Compra validada correctamente',
      html: `
        <p><strong>El producto se envió correctamente al usuario:</strong> ${this.comprador.nombre}</p>
        <p><strong>Coste final:</strong> ${costeFinal.toFixed(2)} €</p>
        <p><strong>Dirección de facturación:</strong> ${this.comprador.direccionFacturacion}</p>
        <p><strong>Datos de pago:</strong><br>${datosPago}</p>
      `,
      confirmButtonText: 'Aceptar'
    });
  }
}
