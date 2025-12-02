//nominales - flecha
//nominales -> function (parametros) {cuerpo}

function realizarCalculo(op1,op2) {
    console.log(`la suma de los dos parametros es ${op1 + op2}`);
}

realizarCalculo(4,5);

function realizarCalculoRetorno(op1,op2) {
    return op1 + op2;
}
function realizarCalculoRetornoDefecto(op1,op2 =7) {
    return op1 + op2;
}

function realizarCalculoFantasma(op1){
    
    const numArgRequeridos = realizarCalculoFantasma.length; 
    
    
    const numArgRecibidos = arguments.length;

    
    const numArgFantasma = numArgRecibidos - numArgRequeridos;

    let suma = 0;
    for(let i = 0; i < arguments.length; i++){
        suma += arguments[i];
    }

    console.log(`Argumentos requeridos: ${numArgRequeridos}`);
    console.log(`Argumentos fantasma: ${numArgFantasma}`);
    console.log(`Suma de todos los argumentos: ${suma}`);
}


realizarCalculoFantasma(2,3,4,5,6);

console.log(`El resultado de la funcion con retorno y parametro por defecto es ${realizarCalculoRetornoDefecto(10)}`);

console.log(`El resultado de la funcion con retorno es ${realizarCalculoRetorno(10,15)}`);