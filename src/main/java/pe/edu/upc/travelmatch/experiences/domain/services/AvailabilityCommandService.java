package pe.edu.upc.travelmatch.experiences.domain.services;

import pe.edu.upc.travelmatch.experiences.domain.model.commands.CreateAvailabilityCommand;

public interface AvailabilityCommandService {
    Long handle(CreateAvailabilityCommand command);
}