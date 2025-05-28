package gruponach.test.domain.model.contratos.tres;

import lombok.Data;

/** DTO para representar el género de un empleado
 * */
@Data
public class GeneroDTO {

    /** * Identificador único del género.
     */
    private Integer id;

    /** * Nombre del género.
     */
    private String name;
}
