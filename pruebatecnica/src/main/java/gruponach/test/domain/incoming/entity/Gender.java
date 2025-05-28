package gruponach.test.domain.incoming.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "genders")
@Data
public class Gender {
    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;
}
