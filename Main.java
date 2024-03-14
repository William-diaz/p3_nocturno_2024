package Recursividad;
public class Main {
    public static void main(String[] args) {
        int [] arreglo = {1, 2, 3, 4, 5};

        // Se llama la función y se incializa el indice.
        recorrerArreglo(arreglo,0);

    //------------------------------------------------------------------------------------------------//

        String cadena = " Hello world ";
        recorrerCadena(cadena, 0);


        //------------------------------------------------------------------------------------------------//

        int[] arregloCeros = {1,0,3,0,0,5,2,0};
        int cantidadCeros = contarCeros(arregloCeros, 0);


        //------------------------------------------------------------------------------------------------//

        char [] letras = {'a','b','w','e','c','u'};
        contarVocales(letras, 0);

        //------------------------------------------------------------------------------------------------//

        String cadenaPalabra = " COLOMBIA ";
        contarVocalesPalabara(cadenaPalabra, 0);

        //------------------------------------------------------------------------------------------------//

        int numero = 12345;
        int suma = sumarCifras(numero);

        //------------------------------------------------------------------------------------------------//

        int numeros = 23932883;
        int cantidad = cantidadCifras(numeros);


    }

    public static void recorrerArreglo (int [] arreglo,int indice){

        // Case base
        if (indice == arreglo.length){
            // no devuelve nada porque ya recorrió el arreglo
            return;
        }
        // Caso recursivo, se llama asi mismo y le va sumando 1 al indice hasta que llegue al caso base
        recorrerArreglo(arreglo, indice + 1);
    }

    public static void recorrerCadena (String cadena, int indice){

        // Case base
        if (indice == cadena.length()){
            return;
        }
        // Caso recursivo
        recorrerCadena(cadena,indice + 1);
    }

    public static int contarCeros (int [] arregloCeros, int indice){

        if (indice == arregloCeros.length){
            return 0;
        }

        // Caso recursivo si encuentra un cero, retorna 1 y suma 1 al indice para avanzar

        if (arregloCeros[indice] == 0){
            return 1 + contarCeros(arregloCeros, indice + 1);
        }

        // Si la posicion no es cero, llama al caso recursivo y aumenta el indide en 1 para avanzar

        else {
            return contarCeros(arregloCeros, indice + 1);
        }
    }

    public static int contarVocales (char [] letras, int indice){

        if (indice == letras.length){
            return 0;
        }
        // Obtener el carácter en el índice actual y convertirlo a minúscula
        char letraActual = Character.toLowerCase(letras[indice]);

        if (letraActual == 'a' || letraActual == 'e' || letraActual == 'i' || letraActual == 'o' || letraActual == 'u'){
            return 1 + contarVocales(letras, indice + 1);

        }

        else {
            return contarVocales( letras, indice + 1);
        }

    }

    public static int contarVocalesPalabara (String cadenaPalabra, int indice){

        if (indice == cadenaPalabra.length()){
            return 0;
        }
        char posicionLetra = Character.toLowerCase(cadenaPalabra.charAt(indice));

        if (posicionLetra == 'a' || posicionLetra == 'e' || posicionLetra == 'i' || posicionLetra == 'o' || posicionLetra == 'u'){
            return 1 + contarVocalesPalabara(cadenaPalabra, indice + 1);

        }
        else {
            return contarVocalesPalabara(cadenaPalabra, indice + 1);
        }
    }

    public static int sumarCifras(int numero) {

        if (numero < 10) {
            return numero;
        }

        // Obtenemos el último dígito del número y lo sumamos con la suma de las cifras restantes
        return numero % 10 + sumarCifras(numero / 10);
    }

    public static int cantidadCifras(int n) {
        // Caso base: si el número es menor que 10, tiene una sola cifra
        if (Math.abs(n) < 10) {
            return 1;
        }
        // Llamada recursiva para obtener la cantidad de cifras del número sin el último dígito
        return 1 + cantidadCifras(n / 10);
    }
}