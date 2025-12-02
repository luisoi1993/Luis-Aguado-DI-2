
let confirmacion;
do{
    let nombre = prompt("Introduce tu nombre:");
    let nota1 = pedirNota();
    let nota2 = pedirNota();
    let nota3 = pedirNota();

    let promedio = (nota1 + nota2 + nota3) / 3;

    alert(`Hola ${nombre}, tu promedio es ${promedio.toFixed(2)}`);
    if (promedio >= 5) {
        alert("¡Felicidades! Has aprobado.");
    } else {
        alert("Lo siento, has reprobado.");
    }
     confirmacion = confirm("¿Quieres calcular otro promedio?");

}while(confirmacion);

function pedirNota(){
    let nota;
    do {
        nota = parseFloat(prompt("Introduce una nota entre 0 y 10:"));
    } while (isNaN(nota) || nota < 0 || nota > 10);
    return nota;
}