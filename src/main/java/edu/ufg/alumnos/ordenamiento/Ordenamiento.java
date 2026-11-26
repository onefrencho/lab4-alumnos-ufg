package edu.ufg.alumnos.ordenamiento;

import java.util.ArrayList;
import java.util.Comparator;

import edu.ufg.alumnos.modelo.Alumno;

/**
 * Algoritmo de ordenamiento por seleccion hecho a mano.
 * No se debe usar Collections.sort ni List.sort.
 */
public final class Ordenamiento {

    private Ordenamiento() {
    }

    /**
     * Ordena la lista que recibe usando Selection Sort y el criterio indicado.
     *
     * @param alumnos  lista a ordenar (se modifica la misma lista)
     * @param criterio Comparator que decide el orden
     */
    public static void seleccion(ArrayList<Alumno> alumnos, Comparator<Alumno> criterio) {
        // Danny: implementar Selection Sort.
        // Por cada posicion i buscar el menor desde i hasta el final usando criterio.compare
        // y despues intercambiarlo con el de la posicion i.
        // Validar que la lista y el criterio no vengan null.
    }
}
