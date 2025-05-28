package gruponach.test.domain.incoming.repository;

import gruponach.test.domain.incoming.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    boolean existsByNameAndLastName(String name, String lastName);
    List<Employee> findAllByJobId(Integer jobId);

}
