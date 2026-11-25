package edu.ufg.alumnos.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import edu.ufg.alumnos.datos.ExcelReader;
import edu.ufg.alumnos.modelo.Alumno;
import edu.ufg.alumnos.ordenamiento.Ordenamiento;

/**
 * Guarda la coleccion de alumnos importados y coordina las operaciones
 * que pide el menu (importar, mostrar y ordenar).
 */
public class GestionAlumnos {

    // Lista principal. Siempre conserva el orden en que vienen las filas del Excel.
    private final ArrayList<Alumno> alumnos = new ArrayList<>();
    private final ExcelReader lector = new ExcelReader();

    /**
     * Importa los alumnos del Excel y los guarda en la coleccion.
     * Si se importa otra vez, la lista anterior se reemplaza para no duplicar registros.
     *
     * @param ruta ruta del archivo .xlsx
     * @return cantidad de alumnos importados
     * @throws IOException si el archivo no existe o no se puede abrir
     */
    public int importar(String ruta) throws IOException {
        // Primero se lee en una lista aparte. Si la lectura falla, la excepcion sale
        // antes de limpiar y no se pierde lo que ya estaba cargado.
        ArrayList<Alumno> leidos = lector.leer(ruta);

        alumnos.clear();
        alumnos.addAll(leidos);

        // Aviso de las filas que el lector no pudo convertir (vacias o con datos malos).
        int omitidas = lector.getFilasOmitidas();
        if (omitidas > 0) {
            System.out.println("Filas omitidas por datos vacios o invalidos: " + omitidas);
        }

        return alumnos.size();
    }

    /** Muestra en consola todos los alumnos tal como vienen en el Excel. */
    public void mostrar() {
        if (!hayAlumnos()) {
            System.out.println("No hay estudiantes importados. Use primero la opcion 1.");
            return;
        }
        imprimirTabla("Estudiantes importados", alumnos);
    }

    /**
     * Ordena una copia de la lista con el criterio indicado y la muestra.
     * Se trabaja sobre una copia para no perder el orden original del Excel,
     * asi la opcion 2 siempre muestra los datos como se importaron.
     *
     * @param criterio Comparator que define el orden (carnet, apellido o promedio)
     * @param titulo   texto que se muestra arriba de la tabla
     */
    public void ordenarYMostrar(Comparator<Alumno> criterio, String titulo) {
        if (!hayAlumnos()) {
            System.out.println("No hay estudiantes importados. Use primero la opcion 1.");
            return;
        }

        ArrayList<Alumno> copia = new ArrayList<>(alumnos);
        Ordenamiento.seleccion(copia, criterio);
        imprimirTabla(titulo, copia);
    }

    /**
     * Imprime una lista de alumnos con encabezado y total al final.
     * La usan tanto mostrar() como ordenarYMostrar() para que todo se vea igual.
     */
    private void imprimirTabla(String titulo, ArrayList<Alumno> lista) {
        System.out.println();
        System.out.println("--- " + titulo + " ---");
        System.out.println(Alumno.encabezadoTabla());
        for (Alumno alumno : lista) {
            System.out.println(alumno);
        }
        System.out.println("Total: " + lista.size() + " estudiante(s)");
    }

    /** Indica si ya se importo al menos un alumno. */
    public boolean hayAlumnos() {
        return !alumnos.isEmpty();
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }
}
