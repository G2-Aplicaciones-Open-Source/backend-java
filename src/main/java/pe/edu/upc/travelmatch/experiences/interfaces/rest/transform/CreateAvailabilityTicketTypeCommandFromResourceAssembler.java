package pe.edu.upc.travelmatch.experiences.interfaces.rest.transform;

import pe.edu.upc.travelmatch.experiences.domain.model.commands.CreateAvailabilityTicketTypeCommand;
import pe.edu.upc.travelmatch.experiences.domain.model.valueobjects.TicketType;
import pe.edu.upc.travelmatch.experiences.domain.model.valueobjects.TicketTypeId;
import pe.edu.upc.travelmatch.experiences.domain.model.aggregates.Availability;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.resources.CreateAvailabilityTicketTypeResource;

public class CreateAvailabilityTicketTypeCommandFromResourceAssembler {
    public static CreateAvailabilityTicketTypeCommand toCommandFromResource(CreateAvailabilityTicketTypeResource resource, Availability availability) {
        return new CreateAvailabilityTicketTypeCommand(
                availability,
                resource.ticketTypeId(),
                TicketType.valueOf(resource.ticketType()),
                resource.price(),
                resource.stock()
        );
    }
}