package gruponach.test.domain.model.contratos.tres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * DTO para representar los datos de cada empleado.
 */

@Data
public class EmpleadoDTO {

    /** * Identificador único del empleado.
     */
    private Integer id;

    /** * Identificador del género del empleado.
     */
    private String name;

    /** * Apellido del empleado.
     */
    @JsonProperty("last_name")
    private String lastName;

    /** * Fecha de nacimiento del empleado.
     */
    private LocalDate birthdate;

    /** * Puesto de trabajo del empleado.
     */
    private PuestoDTO job;

    /** Género del empleado.
     */
    private GeneroDTO gender;
}
