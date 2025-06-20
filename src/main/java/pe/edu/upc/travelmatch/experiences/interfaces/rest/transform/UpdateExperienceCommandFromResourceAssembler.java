package pe.edu.upc.travelmatch.experiences.interfaces.rest.transform;

import pe.edu.upc.travelmatch.experiences.domain.model.commands.UpdateExperienceCommand;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.resources.UpdateExperienceResource;

public class UpdateExperienceCommandFromResourceAssembler {
    public static UpdateExperienceCommand toCommandFromResource(UpdateExperienceResource resource, Long id) {
        return new UpdateExperienceCommand(
                id,
                resource.title(),
                resource.description(),
                resource.categoryId(),
                resource.destinationId(),
                resource.duration(),
                resource.meetingPoint()
        );
    }
}