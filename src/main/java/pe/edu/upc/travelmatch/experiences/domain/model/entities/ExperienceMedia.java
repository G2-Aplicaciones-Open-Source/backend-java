package pe.edu.upc.travelmatch.experiences.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.experiences.domain.model.aggregates.Experience;
import pe.edu.upc.travelmatch.shared.domain.model.entities.AuditableModel;

import java.util.Date;

@Entity
@Table(name = "experience_media")
@NoArgsConstructor
public class ExperienceMedia extends AuditableModel {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "experience_id", nullable = false)
    private Experience experience;

    @Getter
    @Column(name = "media_url", nullable = false, length = 256)
    private String mediaUrl;

    @Getter
    @Column(name = "caption", length = 256)
    private String caption;

    @Getter
    @Column(name = "deleted_at")
    private Date deletedAt;

    public ExperienceMedia(Experience experience, String mediaUrl, String caption) {
        this.experience = experience;
        this.mediaUrl = mediaUrl;
        this.caption = caption;
    }

    public void update(String mediaUrl, String caption) {
        this.mediaUrl = mediaUrl;
        this.caption = caption;
    }

    public void markAsDeleted() {
        this.deletedAt = new Date();
    }

    public Experience getExperience() {
        return experience;
    }
}