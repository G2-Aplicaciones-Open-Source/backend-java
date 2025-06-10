package pe.edu.upc.travelmatch.experiences.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.travelmatch.experiences.domain.model.aggregates.Availability;
import pe.edu.upc.travelmatch.experiences.domain.model.commands.CreateAvailabilityCommand;
import pe.edu.upc.travelmatch.experiences.domain.services.AvailabilityCommandService;
import pe.edu.upc.travelmatch.experiences.infrastructure.persistence.jpa.repositories.AvailabilityRepository;
import pe.edu.upc.travelmatch.experiences.infrastructure.persistence.jpa.repositories.ExperienceRepository;

@Service
public class AvailabilityCommandServiceImpl implements AvailabilityCommandService {

    private final AvailabilityRepository availabilityRepository;
    private final ExperienceRepository experienceRepository;

    public AvailabilityCommandServiceImpl(AvailabilityRepository availabilityRepository,
                                          ExperienceRepository experienceRepository) {
        this.availabilityRepository = availabilityRepository;
        this.experienceRepository = experienceRepository;
    }

    @Override
    public Long handle(CreateAvailabilityCommand command) {
        if (!experienceRepository.existsById(command.experienceId())) {
            throw new IllegalArgumentException("Experience with ID " + command.experienceId() + " does not exist.");
        }

        var availability = new Availability(
                command.experienceId(),
                command.availableDate(),
                command.capacity()
        );
        var saved = availabilityRepository.save(availability);
        return saved.getId();
    }


}