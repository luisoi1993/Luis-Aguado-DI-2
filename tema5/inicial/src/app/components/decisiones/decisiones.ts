import { Component } from '@angular/core';

@Component({
  selector: 'app-decisiones',
  standalone: false,
  templateUrl: './decisiones.html',
  styleUrl: './decisiones.css',
})
export class Decisiones {

  mostrar = true;
  contratado: boolean | null = null;

  candidato = {
    nombre: '',
    apellido: '',
    edad: null as number | null,
    salario: null as number | null,
    experiencia: null as number | null,
  };

  mostarBoton() {
    this.mostrar = !this.mostrar;
  }

  guardarCandidato() {
    const { edad, salario, experiencia } = this.candidato;

    if (
      edad! >= 18 &&
      (
        (salario! < 20000 && experiencia! < 2) ||
        (salario! < 50000 && experiencia! >= 3) ||
        (experiencia! >= 10)
      )
    ) {
      this.contratado = true;
    } else {
      this.contratado = false;
    }

    console.log('Candidato evaluado:', this.candidato);

    setTimeout(() => {
      this.resetearFormulario();
    }, 5000);
    
  }

  resetearFormulario() {
    this.candidato = {
      nombre: '',
      apellido: '',
      edad: null,
      salario: null,
      experiencia: null,
    };
    this.contratado = null;
  }
}
