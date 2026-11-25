# Laboratorio 4

Aplicación de consola en Java + Maven que lee un Excel de estudiantes con Apache POI, convierte cada fila en un objeto `Alumno`, los guarda en un `ArrayList` y los ordena con Selection Sort usando `Comparator`.

## Reparto

| Integrante | Parte pendiente | Rama |
| --- | --- | --- |
| Alfaro (líder) | Repo y tablero, menú en `Main`, `GestionAlumnos`, README final y entrega | `feature/menu-gestion` |
| Celis | Clase `Alumno` completa y Excel de pruebas | `feature/alumno` |
| Rene | Lectura del Excel con Apache POI (`ExcelReader`) | `feature/excel-reader` |
| Fran | Comparadores, Selection Sort y pruebas | `feature/ordenamiento` |

Cada quien trabaja en su rama, sube sus commits y abre un PR hacia `main`. Antes de aceptar un PR otro compañero lo revisa y lo mueve a "En revisión" en el tablero.

## Estructura

```
datos/alumnos.xlsx                Excel de muestra (fila 1 = encabezados)
src/main/java/edu/ufg/alumnos/
  Main.java                       menú
  modelo/Alumno.java
  datos/ExcelReader.java
  ordenamiento/ComparadoresAlumno.java
  ordenamiento/Ordenamiento.java
  servicio/GestionAlumnos.java
enlaces.txt                       repo, tablero y video
```

## Cómo ejecutar

Requisitos: JDK 17 o superior y Maven (NetBeans ya lo trae).

**NetBeans:** File > Open Project, seleccionar la carpeta del proyecto y dar Run. La primera vez descarga Apache POI.

**Consola:**

```
mvn compile exec:java
```

En la opción 1 se puede presionar Enter para usar `datos/alumnos.xlsx` o escribir otra ruta.

> Alfaro completa esta sección al final con capturas y pasos para el docente.
