package pe.edu.upc.travelmatch.experiences.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.travelmatch.experiences.domain.model.aggregates.Experience;
import pe.edu.upc.travelmatch.experiences.domain.model.commands.CreateExperienceCommand;
import pe.edu.upc.travelmatch.experiences.domain.services.ExperienceCommandService;
import pe.edu.upc.travelmatch.experiences.infrastructure.persistence.jpa.repositories.ExperienceRepository;

@Service
public class ExperienceCommandServiceImpl implements ExperienceCommandService {

    private final ExperienceRepository experienceRepository;

    public ExperienceCommandServiceImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public Long handle(CreateExperienceCommand command) {
        var experience = new Experience(
                command.title(),
                command.description(),
                command.agencyId(),
                command.categoryId(),
                command.destinationId()
        );
        var saved = experienceRepository.save(experience);
        return saved.getId();
    }
}