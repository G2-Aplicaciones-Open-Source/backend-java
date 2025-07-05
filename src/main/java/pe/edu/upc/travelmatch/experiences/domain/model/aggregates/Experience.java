package pe.edu.upc.travelmatch.experiences.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.experiences.domain.model.entities.ExperienceMedia;
import pe.edu.upc.travelmatch.experiences.domain.model.valueobjects.*;
import pe.edu.upc.travelmatch.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Embedded
    @Getter
    @AttributeOverride(name = "value", column = @Column(name = "agency_id", nullable = false))
    private AgencyId agencyId;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Embedded
    @Getter
    @AttributeOverride(name = "value", column = @Column(name = "destination_id", nullable = false))
    private DestinationId destinationId;

    @Getter
    @Column(columnDefinition = "TEXT")
    private String duration;

    @Getter
    @Column(name = "meeting_point", columnDefinition = "TEXT")
    private String meetingPoint;

    @Getter
    @Column(name = "deleted_at")
    private Date deletedAt;

    @OneToMany(mappedBy = "experience", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Availability> availabilities = new ArrayList<>();

    @OneToMany(mappedBy = "experience", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExperienceMedia> media = new ArrayList<>();

    public Experience(String title, String description, AgencyId agencyId, Category category,
                      DestinationId destinationId, String duration, String meetingPoint) {
        this.title = title;
        this.description = description;
        this.agencyId = agencyId;
        this.category = category;
        this.destinationId = destinationId;
        this.duration = duration;
        this.meetingPoint = meetingPoint;
    }

    public ExperienceId getExperienceId() {
        return new ExperienceId(getId());
    }

    public void markAsDeleted() {
        this.deletedAt = new Date();
    }

    public void updateInfo(String title, String description, Category category, DestinationId destinationId,
                           String duration, String meetingPoint) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.destinationId = destinationId;
        this.duration = duration;
        this.meetingPoint = meetingPoint;
    }
}