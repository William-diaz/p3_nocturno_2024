package Recursividad;
public class SumarElementos {
        // Método recursivo para calcular la suma de todos los elementos en una matriz
        public static int sumaMatriz(int[][] matriz, int fila, int columna) {
            // Caso base: si la fila está fuera de los límites de la matriz, retornamos 0
            if (fila >= matriz.length) {
                return 0;
            }
            // Caso base: si la columna está fuera de los límites de la matriz, pasamos a la siguiente fila
            if (columna >= matriz[fila].length) {
                return sumaMatriz(matriz, fila + 1, 0);
            }
            // Llamada recursiva para sumar los elementos de la fila actual y la siguiente columna
            int sumaActual = matriz[fila][columna] + sumaMatriz(matriz, fila, columna + 1);
            return sumaActual;
        }

        public static void main(String[] args) {
            int[][] matriz = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            // Llamamos al método recursivo para calcular la suma de la matriz
            int sumaTotal = sumaMatriz(matriz, 0, 0);
            System.out.println("La suma de todos los elementos en la matriz es: " + sumaTotal);
        }
    }


