package gruponach.test.domain.model.contratos.cinco;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * DTO para la respuesta de pago.
 */
@Data
public class PagoResponse {

    /** Cantidad del pago realizado. */
    private BigDecimal payment;

    /** Estatus de la operación. */
    @JsonProperty("success")
    private boolean exito;

    public boolean isExito() {
        return this.exito;
    }
}
