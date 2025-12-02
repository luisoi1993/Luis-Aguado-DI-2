/*console.log("esta ejecucion se llama desde js independoeniente");
let datos ="Pagina JS";
var asignatura = "DI"; // ambito global
if (true) {
    const DNI = "12345678A"; // constante que guarda el ambito
    let nombre = "borja"; // variable que guarda el ambito
    console.log(nombre);
    console.log(DNI);
}

console.log(datos);
console.log(asignatura); */
/* let nombre = "Borja"; // string
let edad = 41; // number
let altura = 1.74; // number -> double / float
let experiencia = false // boolean 
let elementos = [] // object -> array
let cosa = null; // object -> null
let dato; // undefined
//NaN -> not a number -> isNaN()

if(typeof nombre === "string"){
    console.log("es un string");
}

console.log (typeof nombre);
console.log ("mi nmbre es " + nombre + " y mi edad es " + edad);
console.log (`mi nombre es ${nombre} y mi edad es ${edad}`);
console.log(`mi nombre es ${borja}`);
 */
/* let nombre = "Luis";
//alert(`Bienvenido ${nombre}`);

confirm("¿Estas seguro de querer continuar?");
let respuesta = confirm("¿Estas seguro de querer continuar?");
if(respuesta){
    console.log("El usuario ha pulsado aceptar");
}else{
    console.log("El usuario ha pulsado cancelar");
} */

    let respuesta = prompt("¿Cual es tu nombre?");
    let confirmacion = true;
   console.log(`El nombre del usuario es ${respuesta}`);
    while(confirmacion == true){
     let operando = prompt("Introduce un numero");
     let operando2 = 0
   let boolean1  = false;
   let boolean2 = false;

   while(boolean1 == false ){
        if(!isNaN(operando)){ 
            boolean1 = true;
            console.log(`El numero introducido es ${operando}`);
   }else{
        operando = prompt("Introduce un numero valido");
   }
   }

   while(boolean2 == false ){
        operando2 = prompt("Introduce otro numero");
        if(!isNaN(operando2)){ 
            boolean2 = true;
            console.log(`El numero introducido es ${operando2}`);
   }else{
        operando2 = prompt("Introduce un numero valido");
   }
   }

   alert(`La suma de los dos numeros es ${parseInt(operando) + parseInt(operando2)}\n La resta de los dos numeros es ${parseInt(operando) - parseInt(operando2)}\n La multiplicacion de los dos numeros es ${parseInt(operando) * parseInt(operando2)}\n La division de los dos numeros es ${parseInt(operando) / parseInt(operando2)}`);

    confirmacion =confirm("¿quieres hacer otra operacion?");
    }
  


   


   