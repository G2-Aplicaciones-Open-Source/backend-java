package pe.edu.upc.travelmatch.bookings.domain.services;

import pe.edu.upc.travelmatch.bookings.domain.model.aggregates.Booking;
import pe.edu.upc.travelmatch.bookings.domain.model.queries.GetAllBookingsQuery;
import pe.edu.upc.travelmatch.bookings.domain.model.queries.GetBookingByIdQuery;
import pe.edu.upc.travelmatch.bookings.domain.model.queries.GetBookingsByAvailabilityIdQuery;
import pe.edu.upc.travelmatch.bookings.domain.model.queries.GetBookingsByUserIdQuery;

import java.util.List;
import java.util.Optional;

public interface BookingQueryService {
    Optional<Booking> handle(GetBookingByIdQuery query);
    List<Booking> handle(GetBookingsByUserIdQuery query);
    List<Booking> handle(GetBookingsByAvailabilityIdQuery query);
    List<Booking> handle(GetAllBookingsQuery query);
}
