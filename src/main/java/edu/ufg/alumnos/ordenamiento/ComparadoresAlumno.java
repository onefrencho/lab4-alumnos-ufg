package edu.ufg.alumnos.ordenamiento;

import java.util.Comparator;

import edu.ufg.alumnos.modelo.Alumno;

/**
 * Criterios para comparar alumnos. Cada metodo devuelve un Comparator
 * que luego se le pasa al Selection Sort.
 */
public final class ComparadoresAlumno {

    private ComparadoresAlumno() {
        // Solo tiene metodos estaticos.
    }

    /** Carnet de menor a mayor. */
    public static Comparator<Alumno> porCarnet() {
        // Fran: implementar el criterio por carnet (ascendente).
        return (a, b) -> 0;
    }

    /** Apellido de la A a la Z. */
    public static Comparator<Alumno> porApellido() {
        // Fran: implementar el criterio por apellido (ascendente).
        // Ojo con mayusculas y tildes, y si dos apellidos son iguales desempatar por nombre.
        return (a, b) -> 0;
    }

    /** Promedio de mayor a menor. */
    public static Comparator<Alumno> porPromedioDesc() {
        // Fran: implementar el criterio por promedio (descendente).
        return (a, b) -> 0;
    }
}
