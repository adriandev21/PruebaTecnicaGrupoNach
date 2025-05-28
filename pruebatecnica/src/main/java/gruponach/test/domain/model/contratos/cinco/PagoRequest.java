package gruponach.test.domain.model.contratos.cinco;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * DTO para la solicitud de pago.
 */
@Data
public class PagoRequest {

    /** ID del empleado al que se le realizará el pago. */
    @JsonProperty("employee_id")
    private Integer employeeId;

    /** Fecha de inicio del periodo para el pago. */
    @JsonProperty("start_date")
    private LocalDate startDate;

    /** Fecha de fin del periodo para el pago. */
    @JsonProperty("end_date")
    private LocalDate endDate;
}
