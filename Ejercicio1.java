import java.util.Random;

public class Dado {
    private int numCaras;
    private int ultimaCara;

    public Dado() {
        numCaras = 6;
        ultimaCara = 1;
    }

    public Dado(int numCaras) {
        this.numCaras = numCaras;
        ultimaCara = 1;
    }

    public int getNumCaras() {
        return numCaras;
    }

    public int getUltimaCara() {
        return ultimaCara;
    }

    public void setNumCaras(int numCaras) {
        this.numCaras = numCaras;
    }

    public int tirar() {
        Random rand = new Random();
        ultimaCara = rand.nextInt(numCaras) + 1;
        return ultimaCara;
    }
}

public class Main {
    public static void main(String[] args) {
        Dado dado1 = new Dado();
        Dado dado2 = new Dado(10);
        Dado dado3 = new Dado(12);

        int suma = 0;

        while (suma < 20) {
            int resultado1 = dado1.tirar();
            int resultado2 = dado2.tirar();
            int resultado3 = dado3.tirar();
            suma = resultado1 + resultado2 + resultado3;
            System.out.println("Resultados de los dados: " + resultado1 + ", " + resultado2 + ", " + resultado3);
        }

        System.out.println("La suma de los dados es mayor o igual a 20!");
    }
}
