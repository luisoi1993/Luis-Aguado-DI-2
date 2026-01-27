import { Component } from '@angular/core';

@Component({
  selector: 'app-formulariodeusuario',
  standalone: false,
  templateUrl: './formulariodeusuario.html',
  styleUrl: './formulariodeusuario.css',
})
export class Formulariodeusuario {
  name : string = '';
  age : number = 0;
}
