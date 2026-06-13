package Service;

import Package.Cliente;
import Package.Mascota;
import Package.Perro;
import Package.Gato;
import Util.InputUtil;

import java.util.*;

public class RefugioService {

    //private List<Cliente> clientes = new ArrayList<>();
    private Map<Cliente, List<Mascota>> mapaAdopciones = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== REFUGIO ANIMAL ===");
            System.out.println("1) Crear cliente");
            System.out.println("2) Registrar mascota");
            System.out.println("3) Ver clientes y mascotas");
            System.out.println("0) Salir");
            System.out.print("Seleccione una opción: ");

            // Usamos  utilidad para leer la opción
            int op = InputUtil.leerInt();

            switch (op) {
                case 1 -> crearCliente();
                case 2 -> registrarMascota();
                case 3 -> mostrarDatos();
                case 0 -> salir = true;
                default -> System.out.println("Opción inválida");
            }
        }
    }

    //  1) CREAR CLIENTE
    private void crearCliente() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();
        Cliente cliente = new Cliente(nombre);
        //clientes.add(new Cliente(nombre));
        mapaAdopciones.put(cliente, new ArrayList<>());
        System.out.println("✅ Cliente registrado con éxito.");
    }

    //  2) REGISTRAR MASCOTA (Manejo de Errores)
    private void registrarMascota() {
        if (mapaAdopciones.isEmpty()) {
            System.out.println(" Error: Debe crear un cliente primero.");
            return;
        }

        List<Cliente> listaClientesTemporal = new ArrayList<>(mapaAdopciones.keySet());
        System.out.println("Seleccione el dueño de la mascota:");
        for (int i = 0; i < listaClientesTemporal.size(); i++) {
            System.out.println((i + 1) + ") " + listaClientesTemporal.get(i).getNombre());
        }
        System.out.print("Número de cliente: ");
        int indice = InputUtil.leerInt() - 1;

        if (indice < 0 || indice >= listaClientesTemporal.size()) {
            System.out.println(" Cliente no válido.");
            return;
        }

        Cliente clienteSeleccionado = listaClientesTemporal.get(indice);

        System.out.print("¿Qué mascota es? (1: Perro / 2: Gato): ");
        int tipo = InputUtil.leerInt();

        System.out.print("Nombre de la mascota: ");
        String nombreMascota = sc.nextLine();

        //  (TRY/CATCH)
        int edadMascota = 0;
        boolean edadValida = false;

        while (!edadValida) {
            System.out.print("Edad de la mascota: ");
            String inputEdad = sc.nextLine();
            try {
                edadMascota = Integer.parseInt(inputEdad);

                //  Validación de edad que debe ser mayor a 0
                if (edadMascota < 0) {
                    System.out.println(" La edad no puede ser negativa.");
                } else {
                    edadValida = true; // Rompe el bucle si todo esta ok
                }
            } catch (NumberFormatException e) {
                System.out.println(" Edad inválida. Por favor, ingrese un número entero.");
            }
        }
        Mascota nuevaMascota = (tipo == 1) ? new Perro(nombreMascota, edadMascota) : new Gato(nombreMascota, edadMascota);
        List<Mascota> mascotasDelCliente = mapaAdopciones.get(clienteSeleccionado);

        mascotasDelCliente.add(nuevaMascota);
        System.out.println("mascota asignada a " + clienteSeleccionado.getNombre() + "dentro del MAP");
        }
        // Creamos el objeto específico según la opción
/*        Mascota nuevaMascota;
        if (tipo == 1) {
            nuevaMascota = new Perro(nombreMascota, edadMascota);
        } else if (tipo == 2) {
            nuevaMascota = new Gato(nombreMascota, edadMascota);
        } else {
            System.out.println(" Tipo inválida. Operación cancelada.");
            return;
        }*/

        // Guardamos la mascota en la mochila de ese cliente específico
       // clienteSeleccionado.agregarMascota(nuevaMascota);
        //System.out.println("✅ Mascota asignada a " + clienteSeleccionado.getNombre());
    //}

    //  3)  Aquí va el Polimorfismo + recorrer el map
    private void mostrarDatos() {
        if (mapaAdopciones.isEmpty()) {
            System.out.println("No hay clientes registrados en el refugio.");
            return;
        }

        System.out.println("\n=== LISTADO GENERAL DE ADOPCIONES ===");
        for (Cliente c : mapaAdopciones.keySet()) {
            System.out.println("\n👤 Dueño: " + c.getNombre());
            List<Mascota> mascotasDelCliente = mapaAdopciones.get(c);

            if (mascotasDelCliente.isEmpty()) {
                System.out.println("   (No tiene mascotas registradas aún)");
            } else {
                //  POLIMORFISMO EN ACCIÓN:
                for (Mascota m : mascotasDelCliente) {
                    System.out.print("   🐾 ");
                    m.mostrarInfo();   // Muestra el nombre y edad
                    System.out.print("      Sonido: ");
                    m.hacerSonido();   // Cambia dinámicamente según si es Perro o Gato
                }
            }
        }
    }
}