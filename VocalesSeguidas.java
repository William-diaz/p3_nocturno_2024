package Recursividad;
import java.util.ArrayList;

public class VocalesSeguidas {

    public static void main(String[] args) {
        String[][] matriz = {
                {"vacio", "carro", "baul", "perro"},
                {"colombia", "casa", "moto", "caza"},
                {"llanta", "reir", "archivo", "silla"},
                {"cocina", "ola", "ave", "freir"}
        };

        ArrayList<String> palabrasConDosVocalesSeguidas = new ArrayList<>();
        int contadorPalabras = 0;
        for (String[] fila : matriz) {
            for (String palabra : fila) {
                if (tieneDosVocalesSeguidas(palabra)) {
                    palabrasConDosVocalesSeguidas.add(palabra);
                    contadorPalabras++;
                }
            }
        }

        System.out.println("Número de palabras con dos vocales seguidas: " + contadorPalabras);
        System.out.println("Palabras con dos vocales seguidas:");
        for (String palabra : palabrasConDosVocalesSeguidas) {
            System.out.println(palabra);
        }
    }

    public static boolean tieneDosVocalesSeguidas(String palabra) {
        palabra = palabra.toLowerCase();
        for (int i = 0; i < palabra.length() - 1; i++) {
            if (esVocal(palabra.charAt(i)) && esVocal(palabra.charAt(i + 1))) {
                return true;
            }
        }
        return false;
    }

    private static boolean esVocal(char letra) {
        return letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u';
    }
}




