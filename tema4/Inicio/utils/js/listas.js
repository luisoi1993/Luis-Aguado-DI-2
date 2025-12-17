let lista = ["palabra1","palabra2","palabra3"];
lista.push("palabra 4", "Palabra 5");
lista.unshift("primera palabra","elemento 2");
lista[2] = "palabra mia";
//lista[100] = "palabra 100";

lista.pop;
lista.shift();
console.log(lista);

lista = lista.filter((element,index) => {
    return element != "palabra3"
});

element = lista.find((element,index) => {
    return element != "palabra3"
});







