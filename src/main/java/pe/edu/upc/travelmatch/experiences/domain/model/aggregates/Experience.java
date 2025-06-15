package pe.edu.upc.travelmatch.experiences.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.experiences.domain.model.valueobjects.*;
import pe.edu.upc.travelmatch.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

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

    public Experience(String title, String description, Long agencyId, Long categoryId, Long destinationId) {
        this.title = title;
        this.description = description;
        this.agencyId = agencyId;
        this.categoryId = categoryId;
        this.destinationId = destinationId;
    }
}