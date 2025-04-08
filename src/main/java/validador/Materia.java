package validador;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

/**
 * Clase que modela una Materia con sus correlativas.
 */
@Getter
@Setter
public class Materia {
    private String nombre;
    private List<Materia> materiasCorrelativas;

    public Materia(String nombre, List<Materia> materiasCorrelativas) {
        this.nombre = nombre;
        this.materiasCorrelativas = materiasCorrelativas;
    }

    /**
     * Verifica si un alumno cumple con todas las correlativas de ESTA materia.
     * @param alumno El alumno a verificar.
     * @returnsi el alumno cumple con las correlativas.
     */
    public boolean cumpleCorrelativas(Alumno alumno) {
        if (alumno == null) {
            return false;
        } else {
            if (this.materiasCorrelativas.isEmpty()) {
                return true;
            } else {
                for (Materia correlativa : this.materiasCorrelativas) {
                    if (!alumno.tieneAprobada(correlativa)) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return Objects.equals(nombre, materia.nombre);
    }
}
