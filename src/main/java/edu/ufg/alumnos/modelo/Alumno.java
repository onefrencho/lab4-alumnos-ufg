package edu.ufg.alumnos.modelo;

/**
 * Representa a un estudiante leido desde el Excel.
 * Cada fila del archivo (sin contar los encabezados) se convierte en un Alumno.
 */
public class Alumno {

    private String carnet;
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;
    private double promedio;
    private int anioIngreso;

    // Constructor completo. Lo dejamos desde la base porque ExcelReader lo necesita
    // para crear los objetos mientras Celis termina el resto de la clase.
    public Alumno(String carnet, String nombre, String apellido, int edad,
                  String carrera, double promedio, int anioIngreso) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carrera = carrera;
        this.promedio = promedio;
        this.anioIngreso = anioIngreso;
    }

    // Celis: agregar el constructor vacio.

    public String getCarnet() {
        return carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    // Celis: agregar los setters con sus validaciones
    // (edad mayor que 0, promedio entre 0 y 10, textos que no vengan vacios).

    // Celis: completar toString() para que cada alumno se vea como una fila de tabla
    // y agregar un metodo estatico encabezadoTabla() con los titulos de las columnas.
    @Override
    public String toString() {
        return carnet + " " + nombre + " " + apellido;
    }
}
