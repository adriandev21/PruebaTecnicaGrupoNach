package gruponach.test.domain.model.contratos.dos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HorasTrabajadasResponse {

    private Integer id;

    @JsonProperty("success")
    private boolean exito;

    public boolean isExito() {
        return this.exito;
    }
}
