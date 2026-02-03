export class Tarea {
  items: string[] = [];

  constructor(
    public titulo: string,
    public responsable: string | undefined,
    public descripcion: string,
    public tipo: 'baja' | 'media' | 'alta',
    public fecha: Date = new Date()
  ) {}

  agregarItem(item: string): void {
    if (item && item.trim().length > 0) {
      this.items.push(item.trim());
    }
  }

  obtenerTareas(): Tarea[] {
    // Este método debería interactuar con un servicio o almacenamiento real
    return [];
  }
}
