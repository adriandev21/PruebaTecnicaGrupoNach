package gruponach.test.domain.model.contratos.tres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * DTO para la respuesta de empleados por puesto.
 */
@Data
public class EmpleadosPuestoResponse {

    /** Lista de empleados que ocupan el puesto especificado. */
    @JsonProperty("employees")
    private List<EmpleadoDTO> empleados;

    /** Estatus de la operación. */
    @JsonProperty("success")
    private boolean exito;

    public boolean isExito() {
        return this.exito;
    }
}
