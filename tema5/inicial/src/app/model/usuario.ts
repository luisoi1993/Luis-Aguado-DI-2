export class Usuario {
    hobbies?: string[] ;
    constructor(
        private nombre: string,
        private apellido: string,
        private edad: number
    ) {
        this.hobbies = [];
    }

    //metodo para poder agregar un hobbie
    agregarHobbie(hobbie: string): void {
        if (hobbie && hobbie.trim().length > 0) {
            this.hobbies?.push(hobbie.trim());
        }
    }
    getNombre(): string {
        return this.nombre;
    }

    mostrarHobbies(): string[] | undefined {
        return this.hobbies;
    }
}