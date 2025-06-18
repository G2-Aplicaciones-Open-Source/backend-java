package pe.edu.upc.travelmatch.experiences.interfaces.rest.transform;

import pe.edu.upc.travelmatch.experiences.domain.model.commands.CreateAvailabilityCommand;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.resources.CreateAvailabilityResource;

public class CreateAvailabilityCommandFromResourceAssembler {
    public static CreateAvailabilityCommand toCommandFromResource(CreateAvailabilityResource resource, Long experienceId) {
        return new CreateAvailabilityCommand(
                experienceId,
                resource.startDateTime(),
                resource.endDateTime(),
                resource.capacity()
        );
    }
}