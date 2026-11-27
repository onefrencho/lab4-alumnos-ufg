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

    public Alumno() {
    }

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

    public void setCarnet(String carnet) {
        if (carnet != null && !carnet.trim().isEmpty()) {
            this.carnet = carnet.trim();
        } else {
            System.out.println("Error: el carnet no puede estar vacio.");
        }
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            System.out.println("Error: el nombre no puede estar vacio.");
        }
    }

    public void setApellido(String apellido) {
        if (apellido != null && !apellido.trim().isEmpty()) {
            this.apellido = apellido.trim();
        } else {
            System.out.println("Error: el apellido no puede estar vacio.");
        }
    }

    public void setEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        } else {
            System.out.println("Error: la edad debe ser mayor que 0.");
        }
    }

    public void setCarrera(String carrera) {
        if (carrera != null && !carrera.trim().isEmpty()) {
            this.carrera = carrera.trim();
        } else {
            System.out.println("Error: la carrera no puede estar vacia.");
        }
    }

    public void setPromedio(double promedio) {
        if (promedio >= 0 && promedio <= 10) {
            this.promedio = promedio;
        } else {
            System.out.println("Error: el promedio debe estar entre 0 y 10.");
        }
    }

    public void setAnioIngreso(int anioIngreso) {
        if (anioIngreso > 0) {
            this.anioIngreso = anioIngreso;
        } else {
            System.out.println("Error: el anio de ingreso debe ser mayor que 0.");
        }
    }

    // %-12s = texto alineado a la izquierda en 12 caracteres
    // %4d   = entero alineado a la derecha en 4 caracteres
    // %8.2f = decimal con 2 decimales en 8 caracteres
    private static final String FORMATO_FILA =  "%-12s | %-15s | %-15s | %4s | %-25s | %8s | %6s";

    public static String encabezadoTabla() {
        String titulos = String.format(FORMATO_FILA, "CARNET", "NOMBRE", "APELLIDO", "EDAD", "CARRERA", "PROMEDIO", "ANIO");

        String separador = "-".repeat(titulos.length());
        return titulos + "\n" + separador;
    }

    @Override
    public String toString() {
        return String.format(FORMATO_FILA, carnet, nombre, apellido, edad, carrera, String.format("%.2f", promedio), anioIngreso);
    }
}
