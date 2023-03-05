import java.util.Arrays;
import java.util.Scanner;

public class Cuadricula {
    private static final int TABLERO_FILAS = 10;
    private static final int TABLERO_COLUMNAS = 10;
    private static final char CASILLA_AGUA = '~';
    private static final char CASILLA_BARCO = 'B';
    private static final char CASILLA_TOCADO = 'X';
    
    private char[][] tablero;
    private int filaBarco;
    private int columnaBarco;
    
    public Cuadricula() {
        tablero = new char[TABLERO_FILAS][TABLERO_COLUMNAS];
        for (int i = 0; i < TABLERO_FILAS; i++) {
            Arrays.fill(tablero[i], CASILLA_AGUA);
        }
        filaBarco = -1;
        columnaBarco = -1;
    }
    
    public void depositarBarco(int fila, int columna) {
        if (fila < 0 || fila >= TABLERO_FILAS || columna < 0 || columna >= TABLERO_COLUMNAS) {
            System.out.println("Coordenadas inválidas");
            return;
        }
        if (tablero[fila][columna] == CASILLA_BARCO) {
            System.out.println("Ya hay un barco en esta celda");
            return;
        }
        tablero[fila][columna] = CASILLA_BARCO;
        filaBarco = fila;
        columnaBarco = columna;
        System.out.println("Barco depositado en " + fila + ", " + columna);
    }
    
    public boolean disparar(int fila, int columna) {
        if (fila < 0 || fila >= TABLERO_FILAS || columna < 0 || columna >= TABLERO_COLUMNAS) {
            System.out.println("Coordenadas inválidas");
            return false;
        }
        if (tablero[fila][columna] == CASILLA_TOCADO) {
            System.out.println("Ya has disparado a esta celda");
            return false;
        }
        if (tablero[fila][columna] == CASILLA_AGUA) {
            System.out.println("Agua!");
            tablero[fila][columna] = CASILLA_TOCADO;
            return false;
        }
        if (tablero[fila][columna] == CASILLA_BARCO) {
            System.out.println("Hundido!");
            tablero[fila][columna] = CASILLA_TOCADO;
            if (fila == filaBarco && columna == columnaBarco) {
                return true;
            }
        }
        return false;
    }
    
    public void visualizacion() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < TABLERO_FILAS; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TABLERO_COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Cuadricula cuadricula = new Cuadricula();
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("¡Bienvenido a la micro guerra de barcos!");
    
        while (!cuadricula.hundido()) {
            cuadricula.visualizacion();
    
            System.out.print("Introduce la fila del disparo (0-9): ");
            int fila = scanner.nextInt();
    
            System.out.print("Introduce la columna del disparo (0-9): ");
            int columna = scanner.nextInt();
    
            boolean hundido = cuadricula.disparar(fila, columna);
            if (hundido) {
                System.out.println("¡Barco hundido!");
            } else {
                System.out.println("Agua...");
            }
        }
    
        cuadricula.visualizacion();
        System.out.println("¡Ganaste la partida!");
    }
}    