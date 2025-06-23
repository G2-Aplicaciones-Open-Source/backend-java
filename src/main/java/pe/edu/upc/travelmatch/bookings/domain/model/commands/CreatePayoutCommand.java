package pe.edu.upc.travelmatch.bookings.domain.model.commands;

import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.AgencyId;

public record CreatePayoutCommand(AgencyId agencyId, int amount, String stripePayoutId) {
}
