package validador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {
    private Materia ayed;
    private Materia pdp;
    private Materia dds;
    private Materia lyed;
    private Materia sypn;
    private Materia asi;

    @BeforeEach
    void setUp() {
        ayed = new Materia("Algoritmos y Estructuras de Datos", new ArrayList<>());
        lyed = new Materia("Logica y Estructuras Discretas", new ArrayList<>());
        sypn = new Materia("Sistemas y Procesos de Negocio", new ArrayList<>());

        List<Materia> correlativasPdp = new ArrayList<>();
        correlativasPdp.add(lyed);
        correlativasPdp.add(ayed);
        pdp = new Materia("Paradigmas de Programacion", correlativasPdp);

        List<Materia> correlativasAsi = new ArrayList<>();
        correlativasAsi.add(lyed);
        correlativasAsi.add(ayed);
        asi = new Materia("Analisis de sistemas", correlativasAsi);

        List<Materia> correlativasDds = new ArrayList<>();
        correlativasDds.add(sypn);
        correlativasDds.add(pdp);
        correlativasDds.add(ayed);
        correlativasDds.add(asi);
        dds = new Materia("Disenio de Sistemas", correlativasDds);
    }

    @Test
    void inscripcionAprobadaSinCorrelativas() {
        Alumno alumno = new Alumno(new ArrayList<>(), "Zoe Mancini", 1L);
        List<Materia> aInscribir = new ArrayList<>();
        aInscribir.add(sypn);
        Inscripcion inscripcion = new Inscripcion(alumno, aInscribir);
        assertTrue(inscripcion.aprobada());
    }

    @Test
    void inscripcionAprobadaMateriaConCorrelativasCumplidas() {
        List<Materia> aprobadas = new ArrayList<>();
        aprobadas.add(ayed);
        aprobadas.add(lyed);
        Alumno alumno = new Alumno(aprobadas, "Zoe Mancini", 1L);

        List<Materia> aInscribir = new ArrayList<>();
        aInscribir.add(pdp);
        Inscripcion inscripcion = new Inscripcion(alumno, aInscribir);
        assertTrue(inscripcion.aprobada());
    }

    @Test
    void inscripcionNoAprobadaMateriaConCorrelativaNoCumplida() {
        Alumno alumno = new Alumno(new ArrayList<>(), "Zoe Mancini", 1L);
        List<Materia> aInscribir = new ArrayList<>();
        aInscribir.add(pdp);
        Inscripcion inscripcion = new Inscripcion(alumno, aInscribir);
        assertFalse(inscripcion.aprobada());
    }

    @Test
    void inscripcionAprobadaMultiplesMateriasConCorrelativasCumplidas() {
        List<Materia> aprobadas = new ArrayList<>();
        aprobadas.add(ayed);
        aprobadas.add(lyed);
        Alumno alumno = new Alumno(aprobadas, "Zoe Mancini", 1L);

        List<Materia> aInscribir = new ArrayList<>();
        aInscribir.add(pdp);
        aInscribir.add(sypn);
        Inscripcion inscripcion = new Inscripcion(alumno, aInscribir);
        assertTrue(inscripcion.aprobada());
    }

    @Test
    void inscripcionNoAprobadaMultiplesMateriasYUnaNoCumple() {
        List<Materia> aprobadas = new ArrayList<>();
        aprobadas.add(ayed);
        Alumno alumno = new Alumno(aprobadas, "Zoe Mancini", 1L);
        List<Materia> aInscribir = new ArrayList<>();
        aInscribir.add(pdp);
        aInscribir.add(dds);
        Inscripcion inscripcion = new Inscripcion(alumno, aInscribir);
        assertFalse(inscripcion.aprobada());
    }

    @Test
    void inscripcionAprobadaConCorrelativasMultiplesParaUnaMateriaYLasCumple() {
        List<Materia> aprobadas = new ArrayList<>();
        aprobadas.add(ayed);
        aprobadas.add(lyed);
        aprobadas.add(pdp);
        aprobadas.add(sypn);
        aprobadas.add(asi);
        Alumno alumno = new Alumno(aprobadas, "Zoe Mancini", 1L);

        List<Materia> aInscribir = new ArrayList<>();
        aInscribir.add(dds);
        Inscripcion inscripcion = new Inscripcion(alumno, aInscribir);
        assertTrue(inscripcion.aprobada());
    }

    @Test
    void inscripcionNoAprobadaConCorrelativasMultiplesParaUnaMateriaYFaltaUna() {
        List<Materia> aprobadas = new ArrayList<>();
        aprobadas.add(ayed);
        aprobadas.add(lyed);
        aprobadas.add(pdp);
        aprobadas.add(sypn);
        Alumno alumno = new Alumno(aprobadas, "Zoe Mancini", 1L);

        List<Materia> aInscribir = new ArrayList<>();
        aInscribir.add(dds);
        Inscripcion inscripcion = new Inscripcion(alumno, aInscribir);
        assertFalse(inscripcion.aprobada());
    }

    @Test
    void inscripcionVaciaDebeSerRechazada() {
        Alumno alumno = new Alumno(new ArrayList<>(), "Zoe Mancini", 1L);
        Inscripcion inscripcion = new Inscripcion(alumno, new ArrayList<>());
        assertFalse(inscripcion.aprobada());
    }
}