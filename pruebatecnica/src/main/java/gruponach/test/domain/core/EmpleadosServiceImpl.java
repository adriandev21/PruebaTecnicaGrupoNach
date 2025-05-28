package gruponach.test.domain.core;

import gruponach.test.domain.incoming.EmpleadosService;
import gruponach.test.domain.incoming.entity.Employee;
import gruponach.test.domain.incoming.entity.Gender;
import gruponach.test.domain.incoming.entity.Job;
import gruponach.test.domain.incoming.entity.Payment;
import gruponach.test.domain.incoming.entity.WorkedHours;
import gruponach.test.domain.incoming.repository.EmployeeRepository;
import gruponach.test.domain.incoming.repository.GenderRepository;
import gruponach.test.domain.incoming.repository.JobRepository;
import gruponach.test.domain.incoming.repository.PaymentRepository;
import gruponach.test.domain.incoming.repository.WorkedHoursRepository;
import gruponach.test.domain.model.contratos.cinco.PagoRequest;
import gruponach.test.domain.model.contratos.cinco.PagoResponse;
import gruponach.test.domain.model.contratos.cuatro.TotalHorasRequest;
import gruponach.test.domain.model.contratos.cuatro.TotalHorasResponse;
import gruponach.test.domain.model.contratos.dos.HorasTrabajadasRequest;
import gruponach.test.domain.model.contratos.dos.HorasTrabajadasResponse;
import gruponach.test.domain.model.contratos.tres.EmpleadoDTO;
import gruponach.test.domain.model.contratos.tres.EmpleadosPuestoRequest;
import gruponach.test.domain.model.contratos.tres.EmpleadosPuestoResponse;
import gruponach.test.domain.model.contratos.tres.GeneroDTO;
import gruponach.test.domain.model.contratos.tres.PuestoDTO;
import gruponach.test.domain.model.contratos.uno.AgregarEmpleadoRequest;
import gruponach.test.domain.model.contratos.uno.AgregarEmpleadoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmpleadosServiceImpl implements EmpleadosService {

    private final EmployeeRepository employeeRepository;
    private final GenderRepository genderRepository;
    private final JobRepository jobRepository;
    private final WorkedHoursRepository workedHoursRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public AgregarEmpleadoResponse addEmployee(AgregarEmpleadoRequest req) {
        AgregarEmpleadoResponse resp = new AgregarEmpleadoResponse();
        // 1) Duplicado
        if (employeeRepository.existsByNameAndLastName(req.getName(), req.getLastName())) {
            resp.setExito(false);
            return resp;
        }
        // 2) Edad ≥ 18
        if (Period.between(req.getBirthdate(), LocalDate.now()).getYears() < 18) {
            resp.setExito(false);
            return resp;
        }
        // 3) Catálogos
        Optional<Gender> g = genderRepository.findById(req.getGenderId());
        Optional<Job>    j = jobRepository.findById(req.getJobId());
        if (g.isEmpty() || j.isEmpty()) {
            resp.setExito(false);
            return resp;
        }
        // 4) Persistir
        Employee e = new Employee();
        e.setGender(g.get());
        e.setJob(j.get());
        e.setName(req.getName());
        e.setLastName(req.getLastName());
        e.setBirthdate(req.getBirthdate());
        Employee saved = employeeRepository.save(e);

        resp.setId(saved.getId());
        resp.setExito(true);
        return resp;
    }

    @Override
    public HorasTrabajadasResponse addWorkedHours(HorasTrabajadasRequest req) {
        HorasTrabajadasResponse resp = new HorasTrabajadasResponse();
        // 1) Empleado existe
        Optional<Employee> emp = employeeRepository.findById(req.getEmployeeId());
        if (emp.isEmpty()) {
            resp.setExito(false);
            return resp;
        }
        // 2) No duplicar día
        if (workedHoursRepository.existsByEmployeeIdAndWorkedDate(
                req.getEmployeeId(), req.getWorkedDate())) {
            resp.setExito(false);
            return resp;
        }
        // 3) Persistir
        WorkedHours wh = new WorkedHours();
        wh.setEmployee(emp.get());
        wh.setWorkedHours(req.getWorkedHours());
        wh.setWorkedDate(req.getWorkedDate());
        WorkedHours saved = workedHoursRepository.save(wh);

        resp.setId(saved.getId());
        resp.setExito(true);
        return resp;
    }

    @Override
    public EmpleadosPuestoResponse getEmployeesByJob(EmpleadosPuestoRequest req) {
        EmpleadosPuestoResponse resp = new EmpleadosPuestoResponse();
        // 1) Puesto existe
        Optional<Job> job = jobRepository.findById(req.getJobId());
        if (job.isEmpty()) {
            resp.setExito(false);
            return resp;
        }
        // 2) Obtener empleados
        List<EmpleadoDTO> lista = employeeRepository
                .findAllByJobId(req.getJobId())
                .stream()
                .map(e -> {
                    EmpleadoDTO dto = new EmpleadoDTO();
                    dto.setId(e.getId());
                    dto.setName(e.getName());
                    dto.setLastName(e.getLastName());
                    dto.setBirthdate(e.getBirthdate());
                    // mapear subobjetos
                    PuestoDTO pd = new PuestoDTO();
                    pd.setId(e.getJob().getId());
                    pd.setName(e.getJob().getName());
                    pd.setSalary(e.getJob().getSalary());
                    dto.setJob(pd);
                    GeneroDTO gd = new GeneroDTO();
                    gd.setId(e.getGender().getId());
                    gd.setName(e.getGender().getName());
                    dto.setGender(gd);
                    return dto;
                })
                .collect(Collectors.toList());

        resp.setEmpleados(lista);
        resp.setExito(true);
        return resp;
    }

    @Override
    public TotalHorasResponse getTotalWorkedHours(TotalHorasRequest req) {
        TotalHorasResponse resp = new TotalHorasResponse();
        // 1) Empleado existe
        if (!employeeRepository.existsById(req.getEmployeeId())) {
            resp.setExito(false);
            return resp;
        }
        // 2) Sumar horas en rango
        Integer total = workedHoursRepository
                .findAllByEmployeeIdAndWorkedDateBetween(
                        req.getEmployeeId(), req.getStartDate(), req.getEndDate())
                .stream()
                .mapToInt(WorkedHours::getWorkedHours)
                .sum();

        resp.setTotalWorkedHours(total);
        resp.setExito(true);
        return resp;
    }

    @Override
    public PagoResponse getPayment(PagoRequest req) {
        PagoResponse resp = new PagoResponse();
        // 1) Empleado existe
        if (!employeeRepository.existsById(req.getEmployeeId())) {
            resp.setExito(false);
            return resp;
        }
        // 2) Sumar pagos en rango
        java.math.BigDecimal suma = paymentRepository
                .findAllByEmployeeIdAndPaymentDateBetween(
                        req.getEmployeeId(), req.getStartDate(), req.getEndDate())
                .stream()
                .map(Payment::getAmount)
                .reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add);

        resp.setPayment(suma);
        resp.setExito(true);
        return resp;
    }
}