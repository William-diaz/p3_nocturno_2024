package Recursividad;

public class SumaDosMatrices {

        public static void main(String[] args) {
            int[][] matriz1 = {
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
            };
            int[][] matriz2 = {
                                {9, 8, 7},
                                {6, 5, 4},
                                {3, 2, 1}
            };

            int[][] resultado = sumaMatrices(matriz1, matriz2);

            // Imprimir la matriz resultado
            imprimirMatriz(resultado);
        }

        public static int[][] sumaMatrices(int[][] matriz1, int[][] matriz2) {
            int filas = matriz1.length;
            int columnas = matriz1[0].length;

            int[][] resultado = new int[filas][columnas];

            // Llamada al método recursivo
            sumarMatricesRecursivo(matriz1, matriz2, resultado, 0, 0);

            return resultado;
        }

        public static void sumarMatricesRecursivo(int[][] matriz1, int[][] matriz2, int[][] resultado, int fila, int columna) {
            // Caso base: si hemos recorrido toda la matriz
            if (fila == matriz1.length)
                return;

            // Caso recursivo: sumar los elementos de las matrices
            resultado[fila][columna] = matriz1[fila][columna] + matriz2[fila][columna];

            // Avanzar a la siguiente columna
            if (columna < matriz1[0].length - 1)
                sumarMatricesRecursivo(matriz1, matriz2, resultado, fila, columna + 1);
                // Avanzar a la siguiente fila
            else
                sumarMatricesRecursivo(matriz1, matriz2, resultado, fila + 1, 0);
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