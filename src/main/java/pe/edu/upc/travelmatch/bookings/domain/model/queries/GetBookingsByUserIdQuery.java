package pe.edu.upc.travelmatch.bookings.domain.model.queries;

import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.UserId;

public record GetBookingsByUserIdQuery(UserId userId) {
}
