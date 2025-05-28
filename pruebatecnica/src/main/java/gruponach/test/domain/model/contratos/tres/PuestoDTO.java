package gruponach.test.domain.model.contratos.tres;

import lombok.Data;

import java.math.BigDecimal;

/**
 * DTO para representar un puesto de trabajo.
 */

@Data
public class PuestoDTO {

    /** * Identificador único del puesto.
     */
    private Integer id;

    /** * Nombre del puesto.
     */
    private String name;

    /** * Descripción del puesto.
     */
    private BigDecimal salary;
}
