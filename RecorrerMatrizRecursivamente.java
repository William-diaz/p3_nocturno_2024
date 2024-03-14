package Recursividad;
public class RecorrerMatrizRecursivamente {

    public static void main(String[] args) {

        // Se crea la matriz:
        int [] [] matriz = {
                            {9,8,7},
                            {6,5,4},
                            {3,2,1}
        };

        // Se llama el metodo:
       recorrerMatriz (matriz, 0, 0);
    }

    private static void recorrerMatriz(int[][] matriz, int i, int j) {

        // Caso base de la funcion
        if(i == matriz.length || j == matriz[i].length){
            System.out.println("Fin de la matriz");

        // Caso recursivo
        }else{
            System.out.print( " " + matriz[i][j]);
            // Cuando la columna llegue al final de la fila, se aumenta i y se reinicia j
            if(j == matriz[i].length-1){
                i++;
                j = 0;
                System.out.println(" ");
            }else{
                j++;
            }
           recorrerMatriz (matriz, i, j);
        }
    }
}

