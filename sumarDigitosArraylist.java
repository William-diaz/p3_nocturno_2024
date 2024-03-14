package Recursividad;
import java.util.ArrayList;

public class sumarDigitosArraylist {

        // Método principal para recorrer la matriz y agregar los números con suma de dígitos mayor a 10 a un ArrayList
        public static void recorrerMatriz(String[][] matriz, int fila, int columna, ArrayList<String> listaNumeros) {
            // Caso base: si hemos terminado de recorrer todas las filas
            if (fila == matriz.length) {
                return;
            }
            // Verificar la suma de dígitos para el número en la posición actual
            String numeroActual = matriz[fila][columna];
            int sumaDigitos = verificarSumaDigitos(numeroActual, 0);
            // Si la suma de dígitos es mayor a 10, agregar el número a la lista
            if (sumaDigitos > 10) {
                listaNumeros.add(numeroActual);
            }
            // Mover a la siguiente posición en la matriz
            // Si llegamos al final de una fila, avanzar a la siguiente fila y reiniciar la columna
            if (columna == matriz[fila].length - 1) {
                recorrerMatriz(matriz, fila + 1, 0, listaNumeros);
            } else {
                // Avanzar a la siguiente columna en la misma fila
                recorrerMatriz(matriz, fila, columna + 1, listaNumeros);
            }
        }

        // Método recursivo para verificar la suma de dígitos de un número
        public static int verificarSumaDigitos(String numero, int indice) {
            // Caso base: si hemos verificado todos los dígitos del número
            if (indice == numero.length()) {
                return 0;
            }
            // Convertir el dígito en la posición actual a entero y sumarlo
            int digito = Character.getNumericValue(numero.charAt(indice));
            // Llamada recursiva para sumar los dígitos restantes
            return digito + verificarSumaDigitos(numero, indice + 1);
        }

        public static void main(String[] args) {
            // Matriz de ejemplo
            String[][] matriz = {
                    {"45410", "10414", "14444", "23410", "02163"},
                    {"54562", "22444", "10010", "99111", "56541"},
                    {"38961", "12555", "", "", ""}
            };
            // ArrayList para almacenar los números con suma de dígitos mayor a 10
            ArrayList<String> listaNumeros = new ArrayList<>();
            // Llamada al método para recorrer la matriz y agregar los números adecuados a la lista
            recorrerMatriz(matriz, 0, 0, listaNumeros);
            // Imprimir la lista de números
            System.out.println("Números con suma de dígitos mayor a 10:");
            for (String numero : listaNumeros) {
                System.out.println(numero);
            }
        }
    }


