package pe.edu.upc.travelmatch.experiences.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.experiences.domain.model.valueobjects.*;
import pe.edu.upc.travelmatch.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import java.util.Date;
@Entity
@Table(name = "experiences")
@NoArgsConstructor
public class Experience extends AuditableAbstractAggregateRoot<Experience> {

    @Getter
    @Column(nullable = false, length = 100)
    private String title;

    @Getter
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Getter
    @Column(nullable = false)
    private Long agencyId;

    @Getter
    @Column(nullable = false)
    private Long categoryId;

    @Getter
    @Column(nullable = false)
    private Long destinationId;

    @Getter
    @Column(columnDefinition = "TEXT")
    private String duration;

    @Getter
    @Column(name = "meeting_point", columnDefinition = "TEXT")
    private String meetingPoint;

    @Getter
    @Column(name = "deleted_at")
    private Date deletedAt;
    public void markAsDeleted() {
        this.deletedAt = new Date();
    }
    public Experience(String title, String description, Long agencyId, Long categoryId,
                      Long destinationId, String duration, String meetingPoint) {
        this.title = title;
        this.description = description;
        this.agencyId = agencyId;
        this.categoryId = categoryId;
        this.destinationId = destinationId;
        this.duration = duration;
        this.meetingPoint = meetingPoint;
    }

    public ExperienceId getExperienceId() {
        return new ExperienceId(getId());
    }

    public void updateInfo(String title, String description, Long categoryId, Long destinationId,
                           String duration, String meetingPoint) {
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
        this.destinationId = destinationId;
        this.duration = duration;
        this.meetingPoint = meetingPoint;
    }

}
