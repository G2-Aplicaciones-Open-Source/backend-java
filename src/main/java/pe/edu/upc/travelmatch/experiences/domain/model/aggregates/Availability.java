package pe.edu.upc.travelmatch.experiences.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.experiences.domain.model.valueobjects.ExperienceId;
import pe.edu.upc.travelmatch.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.time.LocalDate;

@Entity
@Table(name = "availabilities")
@NoArgsConstructor
public class Availability extends AuditableAbstractAggregateRoot<Availability> {

    @Getter
    @Column(nullable = false)
    private Long experienceId;

    @Getter
    @Column(nullable = false)
    private LocalDate availableDate;

    @Getter
    @Column(nullable = false)
    private int capacity;

    public Availability(Long experienceId, LocalDate availableDate, int capacity) {
        this.experienceId = experienceId;
        this.availableDate = availableDate;
        this.capacity = capacity;
    }
}