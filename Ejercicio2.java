import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private static int ultimoNumeroCliente = 0;
    private int numeroCliente;
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.numeroCliente = ++ultimoNumeroCliente;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 3) {
            System.out.println("-- Menú --");
            System.out.println("1 - Mostrar clientes");
            System.out.println("2 - Crear un cliente");
            System.out.println("3 - Salir");
            System.out.print("\nSeleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nLista de clientes:");
                    for (Cliente cliente : clientes) {
                        System.out.println(cliente.getNumeroCliente() + " - " + cliente.getNombre());
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.print("\n¿Nombre? ");
                    String nombre = scanner.nextLine();
                    Cliente cliente = new Cliente(nombre);
                    clientes.add(cliente);
                    System.out.println("\nCliente n." + cliente.getNumeroCliente() + " [" + cliente.getNombre() + "] añadido\n");
                    break;

                case 3:
                    System.out.println("\nSaliendo...");
                    break;

                default:
                    System.out.println("\nOpción inválida\n");
            }
        }

        scanner.close();
    }
}
