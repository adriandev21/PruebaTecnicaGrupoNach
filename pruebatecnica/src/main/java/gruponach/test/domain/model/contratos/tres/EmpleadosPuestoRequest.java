package gruponach.test.domain.model.contratos.tres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmpleadosPuestoRequest {

    @JsonProperty("job_id")
    private Integer jobId;
}
