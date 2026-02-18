import { Component, signal } from '@angular/core';
import Swal from 'sweetalert2'
@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('examenFinal');
  showAlert() {
    Swal.fire({
      title: '¡Alerta!',
      text: '¡Has hecho clic en el botón!',
      icon: 'success',
      confirmButtonText: 'Aceptar'
    });
  }
}
