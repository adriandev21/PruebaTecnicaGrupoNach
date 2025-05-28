package gruponach.test.domain.incoming.repository;

import gruponach.test.domain.incoming.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findAllByEmployeeIdAndPaymentDateBetween(Integer employeeId, LocalDate start, LocalDate end);

}
