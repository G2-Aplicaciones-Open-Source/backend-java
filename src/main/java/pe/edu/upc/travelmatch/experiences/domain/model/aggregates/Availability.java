package pe.edu.upc.travelmatch.experiences.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.experiences.domain.model.valueobjects.ExperienceId;
import pe.edu.upc.travelmatch.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "availabilities")
@NoArgsConstructor
public class Availability extends AuditableAbstractAggregateRoot<Availability> {

    @Getter
    @Column(name = "experience_id", nullable = false)
    private Long experienceId;

    @Getter
    @Column(name = "start_datetime", nullable = false)
    private LocalDateTime startDateTime;

    @Getter
    @Column(name = "end_datetime", nullable = false)
    private LocalDateTime endDateTime;

    @Getter
    @Column(nullable = false)
    private int capacity;

    @Getter
    @Column(name = "deleted_at")
    private Date deletedAt;

    public Availability(Long experienceId, LocalDateTime startDateTime, LocalDateTime endDateTime, int capacity) {
        this.experienceId = experienceId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.capacity = capacity;
    }

    public void updateInfo(LocalDateTime startDateTime, LocalDateTime endDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.capacity = capacity;
    }

    public void markAsDeleted() {
        this.deletedAt = new Date();
    }
}