package gruponach.test.domain.model.contratos.cuatro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * DTO que representa la solicitud para obtener el total de horas trabajadas.
 */
@Data
public class TotalHorasResponse {

    /** Total de horas trabajadas. */
    @JsonProperty("total_worked_hours")
    private Integer totalWorkedHours;

    /** Estatus de la operación. */
    @JsonProperty("success")
    private boolean exito;

    public boolean isExito() {
        return this.exito;
    }
}
