package edu.ufg.alumnos;

import java.io.IOException;
import java.util.Scanner;

import edu.ufg.alumnos.ordenamiento.ComparadoresAlumno;
import edu.ufg.alumnos.servicio.GestionAlumnos;

/**
 * Menu principal del laboratorio 4.
 */
public class Main {

    // Archivo que se usa si el usuario solo presiona Enter al importar.
    private static final String RUTA_POR_DEFECTO = "datos/alumnos.xlsx";

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        GestionAlumnos gestion = new GestionAlumnos();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion(entrada);

            switch (opcion) {
                case 1 -> importar(entrada, gestion);
                case 2 -> gestion.mostrar();
                case 3 -> gestion.ordenarYMostrar(ComparadoresAlumno.porCarnet(), "Ordenados por carnet (ascendente)");
                case 4 -> gestion.ordenarYMostrar(ComparadoresAlumno.porApellido(), "Ordenados por apellido (ascendente)");
                case 5 -> gestion.ordenarYMostrar(ComparadoresAlumno.porPromedioDesc(), "Ordenados por promedio (descendente)");
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 6);

        entrada.close();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("===== LABORATORIO 4 - ALUMNOS =====");
        System.out.println("1. Importar estudiantes desde Excel");
        System.out.println("2. Mostrar estudiantes importados");
        System.out.println("3. Ordenar por carnet (ascendente)");
        System.out.println("4. Ordenar por apellido (ascendente)");
        System.out.println("5. Ordenar por promedio (descendente)");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static int leerOpcion(Scanner entrada) {
        // Alfaro: controlar cuando escriben letras o dejan vacio (no debe cerrarse el programa).
        return Integer.parseInt(entrada.nextLine().trim());
    }

    private static void importar(Scanner entrada, GestionAlumnos gestion) {
        System.out.print("Ruta del Excel (Enter para usar " + RUTA_POR_DEFECTO + "): ");
        String ruta = entrada.nextLine().trim();
        if (ruta.isEmpty()) {
            ruta = RUTA_POR_DEFECTO;
        }

        try {
            int total = gestion.importar(ruta);
            System.out.println("Alumnos importados: " + total);
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }

    // Alfaro: en las opciones 2 a 5 avisar que primero hay que importar si la lista esta vacia.
}
