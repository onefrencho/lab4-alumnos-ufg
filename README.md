# Laboratorio 4

Lee un Excel de estudiantes con Apache POI, los guarda en un `ArrayList<Alumno>` y los ordena con Selection Sort usando `Comparator`.

| Integrante | Parte |
| --- | --- |
| Alfaro | Repo y tablero, menú, GestionAlumnos y entrega |
| Celis | Clase Alumno y Excel de pruebas |
| Rene | Lectura del Excel con Apache POI |
| Fran | Comparadores y Selection Sort |
| Danny | Pruebas, revisión y capturas de los ordenamientos |

## Cómo correrlo

Requisito: JDK 17 o superior.

**NetBeans**
1. File > Open Project y elegir la carpeta del proyecto.
2. Clean and Build (la primera vez descarga Apache POI).
3. Run. En la opción 1 se puede dar Enter para usar `datos/alumnos.xlsx`.

**Consola**

```
mvn compile exec:java
```
