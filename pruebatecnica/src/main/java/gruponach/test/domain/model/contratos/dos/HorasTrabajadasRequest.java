package gruponach.test.domain.model.contratos.dos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class HorasTrabajadasRequest {

    @JsonProperty("employee_id")
    private Integer employeeId;

    @JsonProperty("worked_hours")
    private Integer workedHours;

    @JsonProperty("worked_date")
    private LocalDate workedDate;
}
