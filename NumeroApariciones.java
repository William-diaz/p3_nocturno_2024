package Recursividad;

public class NumeroApariciones {

    public static void main (String[] args){
        int [] arreglo = {1,3,5,2,6,7,6};
        int elemento = 6;
        numeroApariciones(arreglo,0,elemento);
        int apariciones = numeroApariciones(arreglo, 0, elemento);
        System.out.println("El número de apariciones de " + elemento + " es: " + apariciones);
    }
    public static int numeroApariciones (int [] arreglo, int indice, int elemento){

        if (indice == arreglo.length){
            return 0;
        }
        if (arreglo[indice] == elemento){
           return 1 + numeroApariciones(arreglo, indice + 1, elemento );

        }else {
            return numeroApariciones(arreglo,indice + 1, elemento );
        }
    }
}
/*
Variación del codigo con inicio y fin

public class Testing {

    public static void main(String[] args) {
        int[] arreglo = {1, 3, 5, 2, 6, 7, 6};
        int inicio = 0;
        int fin = arreglo.length - 1; // El índice del último elemento del arreglo
        int elemento = 6;

        int apariciones = numeroApariciones(arreglo, inicio, fin, elemento);
        System.out.println("El número de apariciones de " + elemento + " es: " + apariciones);
    }

    public static int numeroApariciones(int[] vector, int inicio, int fin, int elem) {
        // Caso base: si inicio supera a fin, significa que hemos recorridotodo
        if (inicio > fin) {
            return 0;
        }

        // Si el elemento en inicio es igual a elem, incrementamos el contador en 1
        // y llamamos recursivamente a la función para buscar en el resto del subarreglo
        if (vector[inicio] == elem) {
            return 1 + numeroApariciones(vector, inicio + 1, fin, elem);
        } else {
            // Si no encontramos el elemento en inicio, llamamos recursivamente
            // a la función para buscar en el resto del subarreglo
            return numeroApariciones(vector, inicio + 1, fin, elem);
        }
    }
}

 */
