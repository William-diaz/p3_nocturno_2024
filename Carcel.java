package BackTracking;
public class Carcel {
    public static char [][] carcel = { // Matriz de la carcel

            {' ', 'P', 'X',' ', 'P','P',' ','P'},
            {' ', 'P', 'P',' ', 'P','P',' ','P'},   // P --> Significa Preso
            {' ', ' ', ' ' ,' ', ' ',' ',' ',' '},  // X --> Significa que falta un preso
            {'P', ' ', 'P','X', ' ','P','P',' '},   // ' ' --> Pasillo
            {'P', ' ', 'X','P', ' ','P','P',' '},
            {' ', ' ', ' ',' ', ' ',' ',' ',' '},
            {'P', 'X', 'P',' ', 'P','P',' ','P'},

    };
    public static int preososEncontrados; // Contador para hallar presos encontrados

    public static void main (String[] args){
        System.out.println("""
                ----------Prisión UQ----------
                """);

        Carcel m = new Carcel();
        final int totalPresos = 26;
        preososEncontrados = 0;
        m.carcel[5][7] = 'C';
        m.resuelve(0,0);
        imprimir(0,0);
        System.out.println("La cantidad de presos encontrados es de: " + preososEncontrados + " presos. =D");
        int presosFaltantes = totalPresos - preososEncontrados;
        System.out.println("Escaparon " + presosFaltantes + " presos de la carcel. :(");
    }
    public void resuelve(int x, int y){
        movimiento(x,y);
        carcel[x][y] = 'S';
    }

    private boolean movimiento(int x, int y){

        if (!esPasoValido(x,y)){ //Evita que se desborde la matriz
            return false;
        }
        if (carcel[x][y] == 'C'){ // Si encuentra a C, vuelve a empezar
            imprimir(0,0);
            return true;
        }

        if (carcel[x][y] == 'P'){// Si encuentra P (preso) suma 1 y cambia por V

            preososEncontrados++;
            carcel[x][y]='V';
            return false;
        }

        if (carcel[x][y] == 'X'){ // Se devuelve(es uno faltante pero como se coloca la resta, entonces seguimos
            return false;
        }
        if (carcel[x][y]== '^' || carcel[x][y]== '+' || carcel[x][y]== 'V') { // Esta linea hace que no se devuelva ya que para esto estan las marcas
            return false;
        }

        carcel [x][y] = '^'; //Cambia donde pisa

        boolean resultado;

        resultado = movimiento(x, y+1); //Movimiento hacia la derecha
        resultado = movimiento(x+1, y); // Movimiento hacia abajo
        resultado = movimiento(x-1, y);  // Movimiento hacia arriba
        resultado = movimiento(x, y-1); // Movimiento hacia la izquierda

        carcel[x][y] = '+'; // Si vuelve a pasar marca con +
        return false;
    }

    private boolean esPasoValido(int x, int y){ // Verfifica si puede moverse, si no se desborda
        if (x >= 0 && x <= carcel.length-1 && y >= 0 && y <= carcel[x].length-1){
            return true;
        }else{
            return false;
        }
    }

    public static void imprimir (int i, int j){ // Imprime las soluciones
        if (carcel.length-1 == i){
            if (carcel[0].length-1 == j){
                System.out.println(carcel[i][j] + "\n");
            }else {
                System.out.print(carcel[i][j] + " ");
                imprimir(i, j+1);
            }
        }
        else{
            if (carcel[0].length-1 == j){
                System.out.println(carcel[i][j] + " ");
                imprimir(i+1,0);
            }else{
                System.out.print(carcel[i][j] + " ");
                imprimir(i,j+1);
            }
        }
    }
}
