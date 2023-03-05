
import java.util.Random;
import java.util.Scanner;

public class Jugador {
    private String nombre;
    private Cuadricula cuadricula;

    public Jugador(String nombre) {
        this.nombre = nombre;
        cuadricula = new Cuadricula();
    }

    public void depositarBarco(int fila, int columna) {
        cuadricula.depositarBarco(fila, columna);
    }

    public boolean disparar(int fila, int columna) {
        return cuadricula.disparar(fila, columna);
    }

    public void visualizacion() {
        System.out.println(nombre + ":");
        cuadricula.visualizacion();
    }
}

class Computadora {
    private Cuadricula cuadricula;

    public Computadora() {
        cuadricula = new Cuadricula();
    }

    public void depositarBarcoAleatorio() {
        Random rand = new Random();
        int fila = rand.nextInt(10);
        int columna = rand.nextInt(10);
        cuadricula.depositarBarco(fila, columna);
    }

    public boolean disparar() {
        Random rand = new Random();
        int fila = rand.nextInt(10);
        int columna = rand.nextInt(10);
        return cuadricula.disparar(fila, columna);
    }

    public void visualizacion() {
        System.out.println("Computadora:");
        cuadricula.visualizacion();
    }
}

public class MicroGuerraBarcos {

    public static void main(String[] args) {
        Jugador jugador = new Jugador("Jugador");
        Computadora computadora = new Computadora();
        Scanner scanner = new Scanner(System.in);

        // el jugador humano deposita su barco
        System.out.println("Bienvenido a la Micro Guerra de Barcos");
        System.out.println("Por favor, introduzca la fila y la columna para depositar su barco:");
        int filaBarco = scanner.nextInt();
        int columnaBarco = scanner.nextInt();
        jugador.depositarBarco(filaBarco, columnaBarco);

        // la computadora deposita su barco aleatoriamente
        computadora.depositarBarcoAleatorio();

        // el jugador humano comienza
        boolean turnoJugador = true;
        boolean hundido = false;
        while (!hundido) {
            if (turnoJugador) {
                // es el turno del jugador humano
                jugador.visualizacion();
                System.out.println("Por favor, introduzca la fila y la columna para disparar:");
                int filaDisparo = scanner.nextInt();
                int columnaDisparo = scanner.nextInt();
                hundido = jugador.disparar(filaDisparo, columnaDisparo);
                turnoJugador = false;
            } else {
                // es el turno de la computadora
                computadora.visualizacion();
                hundido = computadora.disparar();
                turnoJugador = true;

            }
        }

        if (turnoJugador) {
            System.out.println("¡Has hundido el barco de la computadora!");
        } else {
            System.out.println("¡La computadora ha hundido tu barco!");
        }
    }
}
package pruebas;

public class Cuadricula {
    private final int FILAS = 10;
    private final int COLUMNAS = 10;
    private final char AGUA = '-';
    private final char BARCO = 'B';
    private final char TOCADO = 'X';
    private final char HUNDIDO = '#';

    private char[][] tabla;

    public Cuadricula() {
        tabla = new char[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tabla[i][j] = AGUA;
            }
        }
    }

    public void depositarBarco(int fila, int columna) {
        tabla[fila][columna] = BARCO;
    }

    public boolean disparar(int fila, int columna) {
        if (tabla[fila][columna] == BARCO) {
            tabla[fila][columna] = HUNDIDO;
            return true;
        } else {
            tabla[fila][columna] = TOCADO;
            return false;
        }
    }

    public void visualizacion() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println();
        }
    }
}




