package gruponach.test.domain.incoming.repository;

import gruponach.test.domain.incoming.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer> {
}
