package edu.ufg.alumnos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ufg.alumnos.modelo.Alumno;
import edu.ufg.alumnos.ordenamiento.Ordenamiento;

class OrdenamientoTest {

    @Test
    void listaVaciaNoFalla() {
        ArrayList<Alumno> vacia = new ArrayList<>();
        Ordenamiento.seleccion(vacia, (a, b) -> 0);
        assertEquals(0, vacia.size());
    }

    // Danny: agregar pruebas para carnet, apellido y promedio,
    // y una con un solo alumno y otra con promedios repetidos.
}
