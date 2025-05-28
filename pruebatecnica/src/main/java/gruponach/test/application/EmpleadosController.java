package gruponach.test.application;


import gruponach.test.domain.incoming.EmpleadosService;
import gruponach.test.domain.model.contratos.cinco.PagoRequest;
import gruponach.test.domain.model.contratos.cinco.PagoResponse;
import gruponach.test.domain.model.contratos.cuatro.TotalHorasRequest;
import gruponach.test.domain.model.contratos.cuatro.TotalHorasResponse;
import gruponach.test.domain.model.contratos.dos.HorasTrabajadasRequest;
import gruponach.test.domain.model.contratos.dos.HorasTrabajadasResponse;
import gruponach.test.domain.model.contratos.tres.EmpleadosPuestoRequest;
import gruponach.test.domain.model.contratos.tres.EmpleadosPuestoResponse;
import gruponach.test.domain.model.contratos.uno.AgregarEmpleadoRequest;
import gruponach.test.domain.model.contratos.uno.AgregarEmpleadoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadosController {

    @Autowired
    private EmpleadosService empleadosService;


    /**
     * Ejercicio 1: Agregar un nuevo empleado
     */
    @PostMapping
    public ResponseEntity<AgregarEmpleadoResponse> agregarNuevoEmpleado(@RequestBody AgregarEmpleadoRequest request) {
        AgregarEmpleadoResponse response = empleadosService.addEmployee(request);
        return new ResponseEntity<>(response,
                response.isExito() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    /**
     * Ejercicio 2: Agregar horas trabajadas
     */
    @PostMapping("/horas-trabajadas")
    public ResponseEntity<HorasTrabajadasResponse> agregarHorasTrabajadas(@RequestBody HorasTrabajadasRequest request) {
        HorasTrabajadasResponse response = empleadosService.addWorkedHours(request);
        return new ResponseEntity<>(response,
                response.isExito() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    /**
     * Ejercicio 3: Consultar empleados por puesto
     */
    @GetMapping("/puesto")
    public ResponseEntity<EmpleadosPuestoResponse> consultarPuesto(@RequestBody EmpleadosPuestoRequest request) {
        EmpleadosPuestoResponse response = empleadosService.getEmployeesByJob(request);
        return new ResponseEntity<>(response,
                response.isExito() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    /**
     * Ejercicio 4: Total de horas trabajadas por rango de fechas
     */
    @GetMapping("/horas-totales")
    public ResponseEntity<TotalHorasResponse> obtenerHorasTotales(@RequestBody TotalHorasRequest request) {
        TotalHorasResponse response = empleadosService.getTotalWorkedHours(request);
        return new ResponseEntity<>(response,
                response.isExito() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    /**
     * Ejercicio 5: Consulta de pago por rango de fechas
     */
    @GetMapping("/pago")
    public ResponseEntity<PagoResponse> obtenerPago(@RequestBody PagoRequest request) {
        PagoResponse response = empleadosService.getPayment(request);
        return new ResponseEntity<>(response,
                response.isExito() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

}
