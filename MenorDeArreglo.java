package Recursividad;

public class MenorDeArreglo {
    /*
    Escriba un método recursivo que retorne el menor elemento de un arreglo
    unidimensional de enteros.
     */
    public static void main(String[] args) {

        int numeroMenor;
        int arreglo [] = {8,3,2,4,5};
        System.out.println("El numero menor del arreglo es: " + encontrarMenor(arreglo,0));
    }

    public static int encontrarMenor(int arreglo[], int indice) {
        // Caso base
        if (indice == arreglo.length - 1) {
            return arreglo[indice];
        }

        // Llamada recursiva para encontrar el menor elemento a partir del siguiente índice
        int menorRestante = encontrarMenor(arreglo, indice + 1);

        // Comparar el elemento actual con el menor encontrado recursivamente
        if (arreglo[indice] < menorRestante) {
            return arreglo[indice];
        } else {
            return menorRestante;
        }
    }
}
