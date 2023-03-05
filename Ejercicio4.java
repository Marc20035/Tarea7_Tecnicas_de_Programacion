import java.util.Random;

public class Cuadricula {
    // Constantes
    private static final int TAMANO_CUADRICULA = 10;
    private static final char AGUA = '~';
    private static final char BARCO = 'O';
    private static final char TOCADO = 'X';
    
    // Atributos
    private char[][] cuadricula;
    
    // Constructor
    public Cuadricula() {
        cuadricula = new char[TAMANO_CUADRICULA][TAMANO_CUADRICULA];
        for (int i = 0; i < TAMANO_CUADRICULA; i++) {
            for (int j = 0; j < TAMANO_CUADRICULA; j++) {
                cuadricula[i][j] = AGUA;
            }
        }
    }
    
    // Métodos
    public void depositarBarco(int fila, int columna) {
        cuadricula[fila][columna] = BARCO;
    }
    
    public boolean disparar(int fila, int columna) {
        if (cuadricula[fila][columna] == BARCO) {
            cuadricula[fila][columna] = TOCADO;
            return true;
        } else {
            return false;
        }
    }
    
    public void visualizacion() {
        System.out.print("  ");
        for (int i = 1; i <= TAMANO_CUADRICULA; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        for (int i = 0; i < TAMANO_CUADRICULA; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < TAMANO_CUADRICULA; j++) {
                System.out.print(cuadricula[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void colocarBarcoComputadora() {
        Random rnd = new Random();
        int fila = rnd.nextInt(TAMANO_CUADRICULA);
        int columna = rnd.nextInt(TAMANO_CUADRICULA);
        depositarBarco(fila, columna);
    }

private void turnoComputadora(Cuadricula cuadriculaHumano) {
    Random rnd = new Random();
    int fila = rnd.nextInt(Cuadricula.TAMANO_CUADRICULA);
    int columna = rnd.nextInt(Cuadricula.TAMANO_CUADRICULA);
    boolean acierto = cuadriculaHumano.disparar(fila, columna);
    System.out.println("La computadora dispara en la celda " + (char) ('A' + fila) + (columna + 1));
    if (acierto) {
        System.out.println("¡La computadora ha acertado!");
        if (cuadriculaHumano.haHundidoBarco(fila, columna)) {
            System.out.println("¡La computadora ha hundido tu barco!");
            barcoHumanoHundido = true;
        }
    } else {
        System.out.println("La computadora ha fallado.");
    }
}
public class Main {
    public static void main(String[] args) {
        Cuadricula jugador = new Cuadricula();
        Cuadricula computadora = new Cuadricula();

        System.out.println("Posiciona tu barco:");
        jugador.depositarBarco(2, 2);
        jugador.visualizacion();

        System.out.println("La computadora está posicionando su barco...");
        computadora.depositarBarcoAleatorio();
        computadora.visualizacion();

        while (true) {
            System.out.println("Tu turno:");
            int x = leerCoordenada("x");
            int y = leerCoordenada("y");
            boolean acierto = computadora.disparar(x, y);
            jugador.visualizacion();
            if (acierto) {
                System.out.println("¡Has hundido el barco de la computadora!");
                break;
            }

            System.out.println("Turno de la computadora:");
            acierto = jugador.dispararAleatorio();
            computadora.visualizacion();
            if (acierto) {
                System.out.println("La computadora ha hundido tu barco. ¡Perdiste!");
                break;
            }
        }
    }

    private static int leerCoordenada(String nombreCoordenada) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la coordenada " + nombreCoordenada + ": ");
        return scanner.nextInt();
        }
    }
}
