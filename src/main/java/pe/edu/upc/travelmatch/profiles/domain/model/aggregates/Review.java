package pe.edu.upc.travelmatch.profiles.domain.model.aggregates;

import pe.edu.upc.travelmatch.profiles.domain.model.valueobjects.ExperienceId;
import pe.edu.upc.travelmatch.profiles.domain.model.valueobjects.Rating;
import pe.edu.upc.travelmatch.profiles.domain.model.valueobjects.UserId;
import pe.edu.upc.travelmatch.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Review extends AuditableAbstractAggregateRoot<Review> {
    @Embedded
    @Getter
    @AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false))
    private UserId userId;

    @Embedded
    @Getter
    @AttributeOverride(name = "experienceId", column = @Column(name = "experience_id", nullable = false))
    private ExperienceId experienceId;

    @Embedded
    @Getter
    private Rating rating;

    @Getter
    @Column(length = 2000) // @Lob si planeas comentarios largos
    private String comment;

    public Review(UserId userId, ExperienceId experienceId, Rating rating, String comment) {
        this.userId = userId;
        this.experienceId = experienceId;
        this.rating = rating;
        this.comment = comment;
    }
}
