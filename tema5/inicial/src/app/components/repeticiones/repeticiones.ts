import { Component } from '@angular/core';
import Swal from 'sweetalert2';
import { Usuario } from '../../model/usuario';
import { UsuarioIf } from '../../model/usuarioif';

@Component({
  selector: 'app-repeticiones',
  standalone: false,
  templateUrl: './repeticiones.html',
  styleUrl: './repeticiones.css',
})
export class Repeticiones {

   hobbiesTemporal: string[] = [];

  usuarios: Usuario[] = [
    new Usuario('Borja', 'Gonzalez', 30),
    new Usuario('Maria', 'Lopez', 25),
    new Usuario('Juan', 'Martinez', 28),
    new Usuario('Marta', 'Garcia', 22),
    new Usuario('Pedro', 'Sanchez', 35),
  ];

  

  agregarUsuario(nombre: string, apellido: string, edad: number): void {
    if (
      nombre &&
      nombre.trim().length > 0 &&
      this.hobbiesTemporal.length >= 1
    ) {
      const nuevoUsuario = new Usuario(nombre.trim(), apellido.trim(), edad);

      if (!this.usuarios.some(user => user.getNombre() === nuevoUsuario.getNombre())) {
        this.usuarios.push(nuevoUsuario);
        this.agregarHobbies(nuevoUsuario, this.hobbiesTemporal);

        Swal.fire({
          icon: 'success',
          title: 'Éxito',
          text: 'Usuario agregado correctamente.',
        });
      } else {
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text: 'El usuario ya existe en la lista.',
        });
      }
    } else {
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'El nombre no puede estar vacío y debe tener al menos un hobby.',
      });
    }
  }

  agregarHobbieTemporal(hobbie: string): void {
    if (hobbie && hobbie.trim().length > 0) {
      this.hobbiesTemporal.push(hobbie.trim());
    }
  }

  agregarHobbies(usuario: Usuario, hobbies: string[]): void {
    hobbies.forEach(hobbie => usuario.agregarHobbie(hobbie));
    this.hobbiesTemporal = [];
  }
}
