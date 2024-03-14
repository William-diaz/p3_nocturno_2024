package BackTracking;
public class CampoDeGuerra {

    public static String [][] campo = {
            {"CA", "E1", "A", "CA", "A", "CA","CA","CA", "E1"},
            {"CA", "E1", "E2", "CA", "A", "E1","CA","E1", "CA"},
            {"CA", "CA", "CA", "CA", "CA", "CA","CA","CA", "CA"}, // A--> Aliados
            {"E1", "CA", "E1", "A", "CA", "CA","E1","CA", "E2"},  // E1 --> Enemigos tipo 1
            {"A", "CA", "A", "CA", "CA", "E2","E1","CA", "E2"},   // E2 --> enemigos tipo 2
            {"CA", "CA", "CA", "CA", "CA", "CA","CA","CA", "CA"}, // CA --> Camino libre
            {"CA", "A", "E1", "CA", "E1", "A","CA","A", "CA"},    // ?? --> Camino ya recorrido
            {"CA", "E2", "CA", "CA", "CA", "E1","CA","CA", "CA"},
            {"CA", "CA", "CA", "A", "CA", "CA","CA","E2", "CA"},
    };

    public static int enemigosTipo1;
    public static int enemigosTipo2;
    public static int aliados;

    public static void main (String[] args){
        System.out.println(""" 
                ----- CAMPO DE GUERRA -----
                """);

        CampoDeGuerra m = new CampoDeGuerra();
        enemigosTipo1 = 0;
        enemigosTipo2 = 0;
        aliados = 0;

        m.campo [5][7] = "G";
        m.resuelve(0,7);
        imprimir (0,0);
        System.out.println("La cantidad de enemigos eliminados tipo1 es de: "
                + enemigosTipo1 + " y de tipo2 es de: " + enemigosTipo2);
        System.out.println("La cantidad de aliados encontrados: " + aliados);
    }
    public void resuelve (int x, int y){
        movimiento(x,y);
        campo[x][y] = "S"; // S-->Salida(Donde empieza)
    }
    private boolean esPasoValido(int x, int y){
        if (x >= 0 && x <= campo.length-1 && y >= 0 && y <= campo[x].length-1){ // Evita que se desborde
            return true;
        }else{
            return false;
        }
    }
    public boolean movimiento (int x, int y){
        if (!esPasoValido(x,y)){
            return false;
        }
        if (campo[x][y].equals("G")){ // G es una solución
            imprimir(0,0);
            return true;
        }

        if (campo[x][y].equals("A")){
            aliados++;
            campo[x][y] = "V";
            return false;
        }
        if (campo[x][y].equals("E1")){
            enemigosTipo1++;
            campo[x][y] = "X";
            return false;
        }
        if (campo[x][y].equals("E2")){
            enemigosTipo2++;
            campo[x][y] = "XX";
            return false;
        }
        if (campo[x][y].equals("??") || campo[x][y].equals("+") || campo[x][y].equals("V") || campo[x][y].equals("X")
        || campo[x][y].equals("XX")){ // comprueba que no vuelva a pasar por donde se dejó la "miga" en el caminos
            return false;
        }
        campo[x][y] = "+";
        boolean result;
        result= movimiento(x, y+1); //Movimiento hacia la derecha
        result= movimiento(x+1, y); //Movimiento hacia abajo
        result= movimiento(x-1, y); //Movimiento hacia arriba
        result= movimiento(x, y-1); //Movimiento izquierda

        campo [x][y] = "??";
        return false;
    }

    public static void imprimir(int i, int j) {  //METODO IMPORTANTE PARA IMPRIMIR LAS SOLUCIONES

        if (campo.length - 1 == i) {
            if (campo[0].length - 1 == j) {
                System.out.println(campo[i][j] + "\n");
            } else {
                System.out.print(campo[i][j] + " ");
                imprimir(i, j + 1);
            }
        } else {
            if (campo[0].length - 1 == j) {
                System.out.println(campo[i][j] + " ");
                imprimir(i + 1, 0);
            } else {
                System.out.print(campo[i][j] + " ");
                imprimir(i, j + 1);
            }
        }
    }
}
