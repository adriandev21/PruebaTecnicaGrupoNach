package gruponach.test.domain.model.contratos.uno;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO para la respuesta de agregar un empleado.
 */
@Getter
@Setter
public class AgregarEmpleadoResponse {

    private Integer id;

    @JsonProperty("success")
    private boolean exito;

    public boolean isExito() {
        return this.exito;
    }
}
