import { Injectable } from '@angular/core';
import { Libro } from '../model/libro';

@Injectable({
  providedIn: 'root',
})
export class Libros {
  libros: Libro[] = [
    {
      id: 1,
      Year: 1974,
      Title: 'Carrie',
      Publisher: 'Doubleday',
      ISBN: '978-0-385-08695-0',
      Pages: 199,
      villains: [
        { name: 'Margaret White' },
        { name: 'Billy Nolan' },
      ],
    },
    {
      id: 2,
      Year: 1975,
      Title: "Salem's Lot",
      Publisher: 'Doubleday',
      ISBN: '978-0-385-00751-1',
      Pages: 439,
      villains: [
        { name: 'Kurt Barlow' },
        { name: 'Richard Straker' },
      ],
    },
    {
      id: 3,
      Year: 1977,
      Title: 'The Shining',
      Publisher: 'Doubleday',
      ISBN: '978-0-385-12167-5',
      Pages: 447,
      villains: [
        { name: 'Jack Torrance' },
      ],
    },
  ];

  getLibros(): Libro[] {
    return this.libros;
  }

  getLibroById(id: number): Libro {
    return this.libros.find((l) => l.id == id) as Libro;
  }
}
