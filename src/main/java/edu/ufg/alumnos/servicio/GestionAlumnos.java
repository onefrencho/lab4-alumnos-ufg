package edu.ufg.alumnos.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import edu.ufg.alumnos.datos.ExcelReader;
import edu.ufg.alumnos.modelo.Alumno;

/**
 * Guarda la coleccion de alumnos importados y coordina las operaciones
 * que pide el menu (importar, mostrar y ordenar).
 */
public class GestionAlumnos {

    private final ArrayList<Alumno> alumnos = new ArrayList<>();
    private final ExcelReader lector = new ExcelReader();

    /**
     * Importa los alumnos del Excel y los guarda en la coleccion.
     *
     * @return cantidad de alumnos importados
     */
    public int importar(String ruta) throws IOException {
        // Alfaro: limpiar la lista antes de importar para no duplicar registros,
        // agregar lo que devuelva el lector y avisar cuantas filas se omitieron.
        return 0;
    }

    /** Muestra en consola todos los alumnos de la coleccion. */
    public void mostrar() {
        // Alfaro: usar el encabezado y el toString de Alumno para imprimir la tabla.
        // Si la lista esta vacia mostrar un mensaje.
    }

    /**
     * Ordena una copia de la lista con el criterio indicado y la muestra.
     * Se trabaja sobre una copia para no perder el orden original del Excel.
     */
    public void ordenarYMostrar(Comparator<Alumno> criterio, String titulo) {
        // Alfaro: copiar la lista, llamar a Ordenamiento.seleccion y mostrar el resultado.
    }

    public boolean hayAlumnos() {
        return !alumnos.isEmpty();
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }
}
