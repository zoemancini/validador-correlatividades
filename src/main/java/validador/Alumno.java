package validador;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

/**
 * Clase que modela a un Alumno con sus materias aprobadas.
 */
@Getter
@Setter
public class Alumno {
    private String nombre;
    private Long legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(List<Materia> materiasAprobadas, String nombre, Long legajo) {
        this.materiasAprobadas = materiasAprobadas;
        this.nombre = nombre;
        this.legajo = legajo;
    }

    /**
     * Verifica si el alumno tiene aprobada una materia específica.
     * @param materia La materia a buscar.
     * @return si la materia esta aprobada.
     */
    public boolean tieneAprobada(Materia materia) {
        if (materia == null) {
            return false;
        }
        return this.materiasAprobadas.contains(materia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(legajo, alumno.legajo);
    }
}
