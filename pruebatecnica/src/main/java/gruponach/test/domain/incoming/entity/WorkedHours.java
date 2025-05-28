package gruponach.test.domain.incoming.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "worked_hours",
        uniqueConstraints = @UniqueConstraint(columnNames = {"employee_id","worked_date"}))
@Data
public class WorkedHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "worked_hours", nullable = false)
    private Integer workedHours;

    @Column(name = "worked_date", nullable = false)
    private LocalDate workedDate;
}