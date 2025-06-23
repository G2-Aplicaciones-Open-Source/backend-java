package pe.edu.upc.travelmatch.bookings.domain.model.queries;

import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.AvailabilityId;

public record GetBookingsByAvailabilityIdQuery(AvailabilityId availabilityId) {
}
