package gruponach.test.domain.model.contratos.uno;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * DTO para la solicitud de agregar un empleado.
 */
@Data
public class AgregarEmpleadoRequest {

    @JsonProperty("gender_id")
    private Integer genderId;

    @JsonProperty("job_id")
    private Integer jobId;

    private String name;

    @JsonProperty("last_name")
    private String lastName;

    private LocalDate birthdate;
}
