package pe.edu.upc.travelmatch.bookings.domain.model.queries;

import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.AgencyId;

public record GetPayoutsByAgencyIdQuery(AgencyId agencyId) {
}
