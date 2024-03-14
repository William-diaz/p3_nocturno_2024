package Recursividad;

public class RecorrerMatrizAlRevesSumando {

    public static void main (String [] args){

        // Se crea la matriz
        int[][] matriz = {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
        };

        int suma = sumarMatriz(matriz, matriz.length - 1, matriz[0].length - 1);
        System.out.println("La suma de los elementos de la matriz es: " + suma);
    }

    public static int sumarMatriz(int[][] matriz, int i, int j) {

        // Caso base: cuando llegamos al inicio de la matriz
        if (i == 0 && j == 0) {
            return matriz[i][j];
        }
        // Caso recursivo: retroceder en columnas y avanzar en filas
        if (j == 0) {
            return matriz[i][j] + sumarMatriz(matriz, i - 1, matriz[0].length - 1);
        } else {
            return matriz[i][j] + sumarMatriz(matriz, i, j - 1);
        }
    }
}



