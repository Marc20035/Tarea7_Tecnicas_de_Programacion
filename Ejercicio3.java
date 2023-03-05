package pruebas;

import java.util.Random;
import java.util.Scanner;

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

    public static void main(String[] args) {
        Cuadricula cuadricula = new Cuadricula();
        Random rand = new Random();
        int filaBarco = rand.nextInt(10);
        int columnaBarco = rand.nextInt(10);
        cuadricula.depositarBarco(filaBarco, columnaBarco);
        System.out.println("Bienvenido a la Micro Guerra de Barcos");
        boolean hundido = false;
        Scanner scanner = new Scanner(System.in);
        while (!hundido) {
            System.out.println("Por favor, introduzca una fila y una columna para disparar:");
            int filaDisparo = scanner.nextInt();
            int columnaDisparo = scanner.nextInt();
            hundido = cuadricula.disparar(filaDisparo, columnaDisparo);
            cuadricula.visualizacion();
        }
        System.out.println("¡Felicidades, has hundido el barco!");
        scanner.close();
    }
}


