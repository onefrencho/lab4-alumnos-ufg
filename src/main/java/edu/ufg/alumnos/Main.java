package edu.ufg.alumnos;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ufg.alumnos.ordenamiento.ComparadoresAlumno;
import edu.ufg.alumnos.servicio.GestionAlumnos;

/**
 * Menu principal del laboratorio 4.
 * Solo se encarga de pedir datos al usuario y llamar a GestionAlumnos.
 */
public class Main {

    // Archivo que se usa si el usuario solo presiona Enter al importar.
    private static final String RUTA_POR_DEFECTO = "datos/alumnos.xlsx";

    // Valor que devuelve leerOpcion() cuando lo escrito no es un numero.
    private static final int OPCION_INVALIDA = -1;
    private static final int OPCION_SALIR = 6;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        GestionAlumnos gestion = new GestionAlumnos();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion(entrada);

            switch (opcion) {
                case 1 -> importar(entrada, gestion);
                case 2 -> {
                    if (hayDatos(gestion)) {
                        gestion.mostrar();
                    }
                }
                case 3 -> {
                    if (hayDatos(gestion)) {
                        gestion.ordenarYMostrar(ComparadoresAlumno.porCarnet(),
                                "Ordenados por carnet (ascendente)");
                    }
                }
                case 4 -> {
                    if (hayDatos(gestion)) {
                        gestion.ordenarYMostrar(ComparadoresAlumno.porApellido(),
                                "Ordenados por apellido (ascendente)");
                    }
                }
                case 5 -> {
                    if (hayDatos(gestion)) {
                        gestion.ordenarYMostrar(ComparadoresAlumno.porPromedioDesc(),
                                "Ordenados por promedio (descendente)");
                    }
                }
                case OPCION_SALIR -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion no valida. Escriba un numero del 1 al 6.");
            }
        } while (opcion != OPCION_SALIR);

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

    /**
     * Lee la opcion del menu sin que el programa se caiga.
     * Si escriben letras o dejan vacio devuelve OPCION_INVALIDA y el menu se repite.
     * Si ya no hay entrada (por ejemplo se cerro la consola) se sale del programa.
     */
    private static int leerOpcion(Scanner entrada) {
        try {
            String texto = entrada.nextLine().trim();
            if (texto.isEmpty()) {
                return OPCION_INVALIDA;
            }
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            return OPCION_INVALIDA;
        } catch (NoSuchElementException e) {
            return OPCION_SALIR;
        }
    }

    /** Pide la ruta del Excel y manda a importar. */
    private static void importar(Scanner entrada, GestionAlumnos gestion) {
        System.out.print("Ruta del Excel (Enter para usar " + RUTA_POR_DEFECTO + "): ");
        String ruta = entrada.hasNextLine() ? entrada.nextLine().trim() : "";
        if (ruta.isEmpty()) {
            ruta = RUTA_POR_DEFECTO;
        }

        try {
            int total = gestion.importar(ruta);
            System.out.println("Alumnos importados: " + total);
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // POI lanza esta excepcion cuando el archivo existe pero no es un .xlsx valido.
            System.out.println("El archivo no es un Excel valido (.xlsx): " + e.getMessage());
        }
    }

    /**
     * Revisa que ya se haya importado algo antes de mostrar u ordenar.
     * Asi las opciones 2 a 5 no trabajan con una lista vacia.
     */
    private static boolean hayDatos(GestionAlumnos gestion) {
        if (!gestion.hayAlumnos()) {
            System.out.println("Primero importe los estudiantes con la opcion 1.");
            return false;
        }
        return true;
    }
}
