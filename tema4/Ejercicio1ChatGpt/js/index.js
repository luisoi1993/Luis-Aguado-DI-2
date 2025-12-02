let nombre = prompt("Ingrese su nombre:");

let precio;

while (true) {
    precio = parseFloat(prompt("Ingrese el precio del producto (debe ser mayor que 0):"));

    if (!isNaN(precio) && precio > 0) {
        break;
    }

    alert("El precio debe ser mayor que 0. Por favor, intente nuevamente.");
}

let descuento;

while (true) {
    descuento = parseFloat(prompt("Ingrese el porcentaje de descuento (entre 0 y 100):"));

    if (!isNaN(descuento) && descuento >= 0 && descuento <= 100) {
        break;
    }

    alert("El porcentaje de descuento debe estar entre 0 y 100. Por favor, intente nuevamente.");
}

let ahorro = precio * descuento / 100;
let precioFinal = precio - ahorro;

alert(`Producto: ${precio}
Descuento: ${descuento}%
Ahorro: ${ahorro}
Precio final para ${nombre}: ${precioFinal}`);
