package validador;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Clase que modela una Inacripcion con el alumno y las materias a inscribir.
 */
@Getter
@Setter
public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materiasAInscribir;

    public Inscripcion(Alumno alumno, List<Materia> materiasAInscribir) {
        this.alumno = alumno;
        this.materiasAInscribir = materiasAInscribir;
    }

    /**
     * Valida si la inscripción esta aprobada según las correlatividades.
     * @return si la inscripcion esta aprobada.
     */
    public boolean aprobada() {
        if (this.materiasAInscribir.isEmpty()) {
            return false;
        } else {
            for (Materia materiaAInscribir : this.materiasAInscribir) {
                if (!materiaAInscribir.cumpleCorrelativas(this.alumno)) {
                    return false;
                }
            }
            return true;
        }
    }
}