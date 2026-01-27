import { Component } from '@angular/core';

@Component({
  selector: 'app-numerarunalista',
  standalone: false,
  templateUrl: './numerarunalista.html',
  styleUrl: './numerarunalista.css',
})
export class Numerarunalista {
   protected readonly nombres = ['Ana', 'Carlos', 'Beatriz', 'David', 'Elena'];

}
