package edu.ufg.alumnos.datos;

import java.io.IOException;
import java.util.ArrayList;

import edu.ufg.alumnos.modelo.Alumno;

/**
 * Lee el archivo Excel con Apache POI y convierte cada fila en un Alumno.
 *
 * Orden de las columnas en el Excel:
 * A carnet | B nombre | C apellido | D edad | E carrera | F promedio | G anioIngreso
 *
 * La fila 1 trae los encabezados y no se toma como registro.
 */
public class ExcelReader {

    private int filasOmitidas;

    /**
     * Abre el archivo y devuelve los alumnos validos que encuentre.
     *
     * @param ruta ruta del archivo .xlsx
     * @return lista con los alumnos leidos
     * @throws IOException si el archivo no existe o no se puede abrir
     */
    public ArrayList<Alumno> leer(String ruta) throws IOException {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        filasOmitidas = 0;

        // René: aqui va la lectura con POI.
        // 1. Abrir el archivo con XSSFWorkbook (usar try-with-resources).
        // 2. Tomar la primera hoja y saltar la fila de encabezados.
        // 3. Recorrer las filas, leer cada celda y armar el Alumno.
        // 4. Si una fila viene vacia o con datos que no sirven, sumarla a filasOmitidas
        //    y seguir con la siguiente para que el programa no se caiga.

        return alumnos;
    }

    /** Cantidad de filas que no se pudieron convertir en la ultima lectura. */
    public int getFilasOmitidas() {
        return filasOmitidas;
    }
}
