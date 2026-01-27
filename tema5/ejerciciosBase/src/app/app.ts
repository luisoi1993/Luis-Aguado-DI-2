import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('ejerciciosBase');
  protected selectedComponent = 'mensajerol';

  protected onSelectComponent(componentName: string): void {
    this.selectedComponent = componentName;
  }
  
}
