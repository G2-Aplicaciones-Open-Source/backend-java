package pe.edu.upc.travelmatch.experiences.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.travelmatch.experiences.application.internal.outboundservices.acl.ExternalIamService;
import pe.edu.upc.travelmatch.experiences.domain.model.aggregates.Experience;
import pe.edu.upc.travelmatch.experiences.domain.model.commands.CreateExperienceCommand;
import pe.edu.upc.travelmatch.experiences.domain.model.commands.UpdateExperienceCommand;
import pe.edu.upc.travelmatch.experiences.domain.services.ExperienceCommandService;
import pe.edu.upc.travelmatch.experiences.infrastructure.persistence.jpa.repositories.ExperienceRepository;

@Service
public class ExperienceCommandServiceImpl implements ExperienceCommandService {

    private final ExperienceRepository experienceRepository;
    private final ExternalIamService externalIamService;

    public ExperienceCommandServiceImpl(ExperienceRepository experienceRepository,
                                        ExternalIamService externalIamService) {
        this.experienceRepository = experienceRepository;
        this.externalIamService = externalIamService;
    }

    @Override
    public Long handle(CreateExperienceCommand command) {
        externalIamService.validateAgencyExists(command.agencyId().value());

        var experience = new Experience(
                command.title(),
                command.description(),
                command.agencyId(),
                command.category(),
                command.destinationId(),
                command.duration(),
                command.meetingPoint()
        );

        var saved = experienceRepository.save(experience);
        return saved.getExperienceId().value();
    }

    @Override
    public void deleteExperience(Long experienceId) {
        var experience = experienceRepository.findById(experienceId)
                .orElseThrow(() -> new RuntimeException("Experience not found"));

        experience.markAsDeleted();
        experienceRepository.save(experience);
    }

    @Override
    public void updateExperience(UpdateExperienceCommand command) {
        var experience = experienceRepository.findById(command.id())
                .orElseThrow(() -> new RuntimeException("Experience not found"));

        experience.updateInfo(
                command.title(),
                command.description(),
                command.category(),
                command.destinationId(),
                command.duration(),
                command.meetingPoint()
        );

        experienceRepository.save(experience);
    }
}