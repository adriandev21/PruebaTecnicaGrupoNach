package gruponach.test.domain.incoming.repository;

import gruponach.test.domain.incoming.entity.WorkedHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkedHoursRepository extends JpaRepository<WorkedHours, Integer> {
    boolean existsByEmployeeIdAndWorkedDate(Integer employeeId, LocalDate date);
    List<WorkedHours> findAllByEmployeeIdAndWorkedDateBetween(Integer employeeId, LocalDate start, LocalDate end);

}
