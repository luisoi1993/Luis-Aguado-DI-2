import { Component } from '@angular/core';

@Component({
  selector: 'app-validaciondeedad',
  standalone: false,
  templateUrl: './validaciondeedad.html',
  styleUrl: './validaciondeedad.css',
})
export class Validaciondeedad {
  
  age = 0;

  validateAge() {
    if (this.age < 18) {
      alert('Eres menor de edad.');
    } else {
      alert('Eres mayor de edad.');
    }
  }
}
