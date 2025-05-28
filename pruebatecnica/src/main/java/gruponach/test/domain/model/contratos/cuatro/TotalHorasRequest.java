package gruponach.test.domain.model.contratos.cuatro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * DTO que representa la solicitud para obtener el total de horas trabajadas por un empleado.
 */
@Data
public class TotalHorasRequest {

    /** Identificador del empleado. */
    @JsonProperty("employee_id")
    private Integer employeeId;

    /** Fecha de inicio del periodo para calcular las horas trabajadas. */
    @JsonProperty("start_date")
    private LocalDate startDate;

    /** Fecha de fin del periodo para calcular las horas trabajadas. */
    @JsonProperty("end_date")
    private LocalDate endDate;
}
