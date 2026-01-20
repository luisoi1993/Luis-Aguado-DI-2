import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('validacionDeEdad');
  age = 0;

  validateAge() {
    if (this.age < 18) {
      alert('Eres menor de edad.');
    } else {
      alert('Eres mayor de edad.');
    }
  }

}
