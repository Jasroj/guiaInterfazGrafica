/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.Random;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author JRS
 */
public class Banco {
    // Crear una cola vacía
    static Queue<String> cola = new LinkedList<String>();
    // Crear una lista de cajas vacía
    static LinkedList<Cliente>[] cajas = new LinkedList[4];
    // Crear un generador de números aleatorios
    static Random rand = new Random();
    // Contadores de clientes atendidos por caja
    static int[] clientesAtendidos = new int[4];
    // Contadores de tiempo de espera y atención por caja
    static int[] tiempoEspera = new int[4];
    static int[] tiempoAtencion = new int[4];
    // Contador de clientes totales
    static int clientesTotales = 0;

    public static void main(String[] args) {
        // Inicializar las cajas
        for (int i = 0; i < 4; i++) {
            cajas[i] = new LinkedList<Cliente>();
        }

        // Menú principal
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("Menú principal:");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Consultas");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    atenderCliente();
                    break;
                case 3:
                    consultas();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 4);
    }

    // Función para agregar un cliente a la cola
    public static void agregarCliente() {
        if (cola.size() >= 15) {
            System.out.println("La fila está llena, no se pueden agregar más clientes.");
            return;
        }
        String ticket = "";
        int prioridad = rand.nextInt(4);
        switch (prioridad) {
            case 0:
                ticket = "A" + (clientesTotales + 1);
                break;
            case 1:
                ticket = "B" + (clientesTotales + 1);
                break;
            case 2:
                ticket = "C" + (clientesTotales + 1);
                break;
            case 3:
                ticket = "D" + (clientesTotales + 1);
                break;
        }
        cola.add(ticket);
        clientesTotales++;
        System.out.println("Se agregó el cliente con ticket " + ticket + " a la fila.");
    }

 public static void atenderCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de caja (1-4): ");
        int caja = scanner.nextInt() - 1;
        if (caja < 0 || caja > 3) {
            System.out.println("Caja inválida.");
            return;
        }
        if (cajas[caja].isEmpty()) {
            if (cola.isEmpty()) {
                System.out.println("No hay clientes en la fila.");
                return;
            }
            String ticket = cola.remove();
            cajas[caja].add(new Cliente(ticket));
            System.out.println("Se atendió al cliente con ticket " + ticket + " en la caja " + (caja + 1) + ".");
        } else {
            Cliente cliente = cajas[caja].peek();
            cliente.tiempoAtencion--;
            if (cliente.tiempoAtencion == 0) {
                cajas[caja].remove();
                clientesAtendidos[caja]++; // Se incrementa el contador de clientes atendidos
                tiempoEspera[caja] += cliente.tiempoEspera; // Se suma el tiempo de espera
                tiempoAtencion[caja] += cliente.tiempoEspera + 1; // Se suma el tiempo de atención
                System.out.println("Se atendió al cliente con ticket " + cliente.ticket + " en la caja " + (caja + 1) + ".");
            } else {
                System.out.println("El cliente con ticket " + cliente.ticket + " sigue siendo atendido en la caja " + (caja + 1) + ".");
            }
        }
    }

    // Función para mostrar las consultas
    public static void consultas() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("Consultas:");
            System.out.println("1. Cantidad de clientes atendidos por caja");
            System.out.println("2. Promedio de tiempo de espera por caja");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    for (int i = 0; i < 4; i++) {
                        System.out.println("Caja " + (i + 1) + ": " + clientesAtendidos[i] + " clientes atendidos.");
                    }
                    break;
                case 2:
                    for (int i = 0; i < 4; i++) {
                        if (clientesAtendidos[i] == 0) {
                            System.out.println("Caja " + (i + 1) + ": no se han atendido clientes.");
                        } else {
                            System.out.println("Caja " + (i + 1) + ": promedio de tiempo de espera " + ((double) tiempoEspera[i] / clientesAtendidos[i]) + " minutos.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Saliendo de las consultas...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 3);
    }

    // Clase para representar un cliente
    static class Cliente {
        String ticket;
        int tiempoEspera;
        int tiempoAtencion;

        public Cliente(String ticket) {
            this.ticket = ticket;
            this.tiempoEspera = rand.nextInt(24) + 2;
            this.tiempoAtencion = this.tiempoEspera + 1;
        }
    }
}