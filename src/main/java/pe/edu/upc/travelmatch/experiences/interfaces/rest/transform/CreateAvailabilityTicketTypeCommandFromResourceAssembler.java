package pe.edu.upc.travelmatch.experiences.interfaces.rest.transform;

import pe.edu.upc.travelmatch.experiences.domain.model.commands.CreateAvailabilityTicketTypeCommand;
import pe.edu.upc.travelmatch.experiences.domain.model.valueobjects.TicketType;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.resources.CreateAvailabilityTicketTypeResource;

public class CreateAvailabilityTicketTypeCommandFromResourceAssembler {
    public static CreateAvailabilityTicketTypeCommand toCommandFromResource(CreateAvailabilityTicketTypeResource resource) {
        return new CreateAvailabilityTicketTypeCommand(
                resource.availabilityId(),
                resource.ticketTypeId(),
                TicketType.valueOf(resource.ticketType()),
                resource.price(),
                resource.stock()
        );
    }
}