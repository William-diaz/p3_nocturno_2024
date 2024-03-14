package BackTracking;

public class Parqueadero {

    public static String [][] parqueadero = {

            {"L"," ","L","C","R1","L"," "},
            {"L"," ","L","C"," ","L", " "},
            {" "," "," ","C"," "," ", " "},
            {"C"," "," ","C","I","I", " "},      // L ESPACIO LIBRE
            {"C"," "," "," "," ","L", " "},      // C CARRO EN ESE ESPACIO
            {"C"," ","C"," "," ","L", " "},      // R ESPACIO RESERVADO
            {"C"," ","C"," ","C","C", " "},      // I ESPACIO DE DISCAPACITADOS
            {" "," ","C"," "," "," ", " "},      // R1 Y R2 LUGAR PARA PARQUEAR
            {"C"," ","C"," ","C"," ", "C"},
            {"C"," ","R"," ","C"," ", "R"},
            {" "," ","R"," ","C","C", "R"},
            {" "," ","R"," "," "," ","R2"},
    };

    public static void main (String[] args){
        System.out.println("Parqueadero :) ");

        Parqueadero m = new Parqueadero();
        m.resuelve(11,0); // Es donde empieza es decir, la entrada
        imprimir(0,0);
        System.out.println("El programa finalizó :D");
    }

    public void resuelve (int x, int y){
        movimiento(x,y);
        parqueadero[x][y] = "S"; // Es la solución
    }
    private boolean esPasoValido (int x, int y){

        if (x >= 0 && x <= parqueadero.length-1 && y >= 0 && y <= parqueadero[x].length-1){ // Evita que se desborde
            return true;
        }else{
            return false;
        }
    }

    public boolean movimiento (int x, int y){
        if (!esPasoValido(x,y)){ //Comprueba que no se desborde
            return false;
        }
        if (parqueadero[x][y].equals("R1")){
            parqueadero[x][y] = "//";
            imprimir(0,0);
            System.out.println("---El primer auto se parqueó---");
            System.out.println(" ");
            return true;
        }
        if (parqueadero[x][y].equals("R2")){
            parqueadero[x][y] = "//";
            imprimir(0,0);
            System.out.println("---El segundo auto se parqueó---");
            System.out.println(" ");
            return true;
    }
        if (parqueadero[x][y].equals("L") || parqueadero[x][y].equals("C") || parqueadero[x][y].equals("R")
                || parqueadero[x][y].equals("I")) {
            return false;
        }
        if (parqueadero[x][y].equals("/") || parqueadero[x][y].equals("+")){ // Si ya ha pasado por el camino
            return false;
        }
        parqueadero[x][y] = "+"; //Por donde pisa lo cambia por + para marcar el camino

        boolean result;

        result = movimiento(x,y+1); // Se mueve hacia la derecha
        result = movimiento(x+1, y); // Se mueve hacia la abajo
        result = movimiento(x-1, y); // Se mueve hacia arriba
        result = movimiento(x,y-1); // Se mueve hacia la izquierda

        parqueadero[x][y] = " "; // Se borra el camino por donde se pasó
        return false;
    }

    public static void imprimir (int i, int j){ // Imprime las soluciones <3

        if (parqueadero.length-1 == i){
            if (parqueadero[0].length-1 == j){
                System.out.println(parqueadero[i][j] + "\n");
            }else {
                System.out.print(parqueadero[i][j] + " ");
                imprimir(i, j+1);
            }
        }
        else {
            if (parqueadero[0].length-1 == j){
                System.out.println(parqueadero[i][j] + " ");
                imprimir(i+1,0);
            }else {
                System.out.print(parqueadero[i][j] + " ");
                imprimir(i,j+1);
            }
        }
    }
}
