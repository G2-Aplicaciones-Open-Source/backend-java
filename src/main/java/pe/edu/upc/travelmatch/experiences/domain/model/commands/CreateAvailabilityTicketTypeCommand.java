
package pe.edu.upc.travelmatch.experiences.domain.model.commands;

import pe.edu.upc.travelmatch.experiences.domain.model.valueobjects.TicketType;

import java.math.BigDecimal;
import pe.edu.upc.travelmatch.experiences.domain.model.aggregates.Availability;
import pe.edu.upc.travelmatch.experiences.domain.model.valueobjects.TicketType;
import java.math.BigDecimal;

public record CreateAvailabilityTicketTypeCommand(
        Availability availability,
        Long ticketTypeId,
        TicketType ticketType,
        BigDecimal price,
        int stock
) {}
