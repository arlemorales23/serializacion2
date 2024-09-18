package org.arle.aplication;

import org.arle.aplication.service.EmpleadoService;
import org.arle.domain.Direccion;
import org.arle.domain.Empleado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class ConsolaUI {
    private final EmpleadoService empleadoService;
    private final Scanner scanner;

    public ConsolaUI(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            System.out.println("\n--- CRUD de Empleados ---");
            System.out.println("1. Crear empleado");
            System.out.println("2. Buscar empleado");
            System.out.println("3. Listar empleados");
            System.out.println("4. Actualizar empleado");
            System.out.println("5. Eliminar empleado");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearEmpleado();
                    break;
                case 2:
                    buscarEmpleado();
                    break;
                case 3:
                    listarEmpleados();
                    break;
                case 4:
                    actualizarEmpleado();
                    break;
                case 5:
                    eliminarEmpleado();
                    break;
                case 6:
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void crearEmpleado() {
        System.out.print("Ingrese el ID del empleado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();

        Empleado empleado = new Empleado(id, nombre);

        System.out.print("¿Cuántas direcciones desea agregar? ");
        int numDirecciones = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        for (int i = 0; i < numDirecciones; i++) {
            System.out.println("Dirección #" + (i + 1));
            System.out.print("Calle: ");
            String calle = scanner.nextLine();
            System.out.print("Ciudad: ");
            String ciudad = scanner.nextLine();
            empleado.addDireccion(new Direccion(calle, ciudad));
        }

        empleadoService.crearEmpleado(empleado);
        System.out.println("Empleado creado exitosamente.");
    }

    private void buscarEmpleado() {
        System.out.print("Ingrese el ID del empleado a buscar: ");
        int id = scanner.nextInt();
        Empleado empleado = empleadoService.obtenerEmpleado(id);
        if (empleado != null) {
            System.out.println(empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private void listarEmpleados() {
        System.out.println("Lista de empleados:");
        empleadoService.listarEmpleados().forEach(System.out::println);
    }

    private void actualizarEmpleado() {
        System.out.print("Ingrese el ID del empleado a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        Empleado empleado = empleadoService.obtenerEmpleado(id);
        if (empleado != null) {
            System.out.print("Ingrese el nuevo nombre del empleado: ");
            String nuevoNombre = scanner.nextLine();
            empleado.setNombre(nuevoNombre);

            empleado.getDirecciones().clear();
            System.out.print("¿Cuántas direcciones desea agregar? ");
            int numDirecciones = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            for (int i = 0; i < numDirecciones; i++) {
                System.out.println("Dirección #" + (i + 1));
                System.out.print("Calle: ");
                String calle = scanner.nextLine();
                System.out.print("Ciudad: ");
                String ciudad = scanner.nextLine();
                empleado.addDireccion(new Direccion(calle, ciudad));
            }

            empleadoService.actualizarEmpleado(empleado);
            System.out.println("Empleado actualizado exitosamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private void eliminarEmpleado() {
        System.out.print("Ingrese el ID del empleado a eliminar: ");
        int id = scanner.nextInt();
        empleadoService.eliminarEmpleado(id);
        System.out.println("Empleado eliminado exitosamente.");
    }
}