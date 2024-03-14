package Recursividad;

public class MatrizTranspuesta {

    public static void main(String[] args) {
        int[][] matrizOriginal = {
                {1, 2, 3},
                {4, 5, 6}};
        System.out.println("Matriz Original:");
        imprimirMatriz(matrizOriginal);

        int[][] matrizTranspuesta = transponerMatriz(matrizOriginal);
        System.out.println("\nMatriz Transpuesta:");
        imprimirMatriz(matrizTranspuesta);
    }
    public static int[][] transponerMatriz(int[][] matriz) {
        // Obtenemos el número de filas de la matriz original
        int filas = matriz.length;
        // Obtenemos el número de columnas de la matriz original
        int columnas = matriz[0].length;
        // Creamos una nueva matriz para almacenar la transpuesta, intercambiando filas por columnas
        int[][] matrizTranspuesta = new int[columnas][filas];
        // Llamamos a la función transponer para realizar el intercambio y obtener la matriz transpuesta
        return transponer(matriz, matrizTranspuesta, 0, 0);
    }

    public static int[][] transponer(int[][] matriz, int[][] matrizTranspuesta, int i, int j) {
        // Verificamos si hemos alcanzado el final de las filas de la matriz original
        if (i == matriz.length) {
            // Si es así, devolvemos la matriz transpuesta completa
            return matrizTranspuesta;
        }

        // Asignamos el valor transpuesto en la posición correspondiente
        matrizTranspuesta[j][i] = matriz[i][j];

        // Verificamos si hemos llegado al final de la fila actual de la matriz original
        if (j == matriz[0].length - 1) {
            // Si es así, llamamos recursivamente a la función para avanzar a la siguiente fila
            return transponer(matriz, matrizTranspuesta, i + 1, 0);
        }

        // Si no hemos llegado al final de la fila, avanzamos a la siguiente columna de la misma fila
        return transponer(matriz, matrizTranspuesta, i, j + 1);
    }

    public static void imprimirMatriz(int[][] matriz) {
        imprimir(matriz, 0, 0);
    }
    public static void imprimir(int[][] matriz, int i, int j) { // Imprimir matriz recursivamente
        if (i == matriz.length)
            return;

        System.out.print(matriz[i][j] + " ");

        if (j == matriz[0].length - 1) {
            System.out.println();
            imprimir(matriz, i + 1, 0);
        } else {
            imprimir(matriz, i, j + 1);
        }
    }
}

