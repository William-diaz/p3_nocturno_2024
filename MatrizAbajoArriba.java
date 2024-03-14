package Recursividad;
public class MatrizAbajoArriba {

    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        recorrerMatrizDesdeAbajo(matriz, matriz.length - 1);
    }

    public static void recorrerMatrizDesdeAbajo(int[][] matriz, int fila) {
        if (fila < 0) {
            return; // Caso base: hemos alcanzado la primera fila, terminamos la recursión
        }

        recorrerFila(matriz, fila, matriz[fila].length - 1);
        recorrerMatrizDesdeAbajo(matriz, fila - 1);
    }

    public static void recorrerFila(int[][] matriz, int fila, int columna) {
        if (columna < 0) {
            return; // Caso base: hemos alcanzado el límite izquierdo de la fila, terminamos la recursión
        }

        System.out.print(matriz[fila][columna] + " ");
        recorrerFila(matriz, fila, columna - 1);
    }
}

