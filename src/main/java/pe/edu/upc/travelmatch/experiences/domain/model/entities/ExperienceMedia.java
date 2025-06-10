package pe.edu.upc.travelmatch.experiences.domain.model.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.shared.domain.model.entities.AuditableModel;

@Entity
@Table(name = "experience_media")
@NoArgsConstructor
public class ExperienceMedia extends AuditableModel {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(nullable = false)
    private Long experienceId;

    @Getter
    @Column(nullable = false)
    private String url;

    @Getter
    @Column(nullable = false)
    private String type;

    public ExperienceMedia(Long experienceId, String url, String type) {
        this.experienceId = experienceId;
        this.url = url;
        this.type = type;
    }
}