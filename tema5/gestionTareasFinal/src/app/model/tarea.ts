export class Tarea {
  items: string[] = [];

  constructor(
    public titulo: string,
    public descripcion: string,
    public tipo: 'baja' | 'media' | 'alta',
    public fecha: Date = new Date()
  ) {}

  agregarItem(item: string): void {
    if (item && item.trim().length > 0) {
      this.items.push(item.trim());
    }
  }
}
