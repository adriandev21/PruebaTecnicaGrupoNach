package gruponach.test.domain.incoming;

import gruponach.test.domain.model.contratos.uno.AgregarEmpleadoRequest;
import gruponach.test.domain.model.contratos.uno.AgregarEmpleadoResponse;
import gruponach.test.domain.model.contratos.dos.HorasTrabajadasRequest;
import gruponach.test.domain.model.contratos.dos.HorasTrabajadasResponse;
import gruponach.test.domain.model.contratos.tres.EmpleadosPuestoRequest;
import gruponach.test.domain.model.contratos.tres.EmpleadosPuestoResponse;
import gruponach.test.domain.model.contratos.cuatro.TotalHorasRequest;
import gruponach.test.domain.model.contratos.cuatro.TotalHorasResponse;
import gruponach.test.domain.model.contratos.cinco.PagoRequest;
import gruponach.test.domain.model.contratos.cinco.PagoResponse;

public interface EmpleadosService {

    AgregarEmpleadoResponse addEmployee(AgregarEmpleadoRequest request);
    HorasTrabajadasResponse addWorkedHours(HorasTrabajadasRequest request);
    EmpleadosPuestoResponse getEmployeesByJob(EmpleadosPuestoRequest request);
    TotalHorasResponse getTotalWorkedHours(TotalHorasRequest request);
    PagoResponse getPayment(PagoRequest request);
}