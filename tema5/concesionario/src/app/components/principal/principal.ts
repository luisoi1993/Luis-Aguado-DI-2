import { Component } from '@angular/core';
import { Coche } from '../../model/coche';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-principal',
  standalone: false,
  templateUrl: './principal.html',
  styleUrl: './principal.css',
})
// hacerlo con el coche de model

export class Principal {
  nuevoCoche: Coche = new Coche('', '', 0, 0, "", '', 0);
    

  coches: Coche[] = [];




  async agregarCoche() {
    if (this.nuevoCoche.marca && this.nuevoCoche.modelo && this.nuevoCoche.cv && this.nuevoCoche.cc && this.nuevoCoche.tipoMotor && this.nuevoCoche.matricula && this.nuevoCoche.precio > 0) {
      this.coches.push({...this.nuevoCoche});
      this.nuevoCoche = {
        marca: '',
        modelo: '',
        cv: 0,
        cc: 0,
        tipoMotor: '',
        matricula: '',
        precio: 0
      };
       if (this.coches.length > 0) {
         await Swal.fire({
            icon: 'info',
            text: 'Ya hay coches registrados , el numero de coches es ' + this.coches.length,
            timer: 2000,
            showConfirmButton: false
          });
      }
      //que el alert se cierre solo a los 3 segundos
     Swal.fire({
      icon: 'success',
      text: 'Coche agregado correctamente',
      timer: 3000,
      showConfirmButton: false
    });
    } else {
      
      Swal.fire({
        icon: 'error',
        text: 'Por favor, complete todos los campos correctamente.',
        
      });
    }
  }

}
