package Recursividad;
public class RecorrerMatrizAlReves {

    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        recorrerMatrizAlReves(matriz, matriz.length - 1, matriz[matriz.length - 1].length - 1);
    }
    public static void recorrerMatrizAlReves(int[][] matriz, int i, int j) {
        
        if (i >= 0 && j >= 0) {
            System.out.print(matriz[i][j] + " ");
            if (j == 0) {
                System.out.println();
                recorrerMatrizAlReves(matriz, i - 1, matriz[i - 1].length - 1);
            } else {
                recorrerMatrizAlReves(matriz, i, j - 1);
            }
        }
    }
}
