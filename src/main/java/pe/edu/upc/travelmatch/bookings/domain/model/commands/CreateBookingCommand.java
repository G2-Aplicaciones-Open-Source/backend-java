package pe.edu.upc.travelmatch.bookings.domain.model.commands;

import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.AvailabilityId;
import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.BookingStatus;
import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.UserId;

import java.math.BigDecimal;

public record CreateBookingCommand(UserId userId, AvailabilityId availabilityId, int quantity, BigDecimal totalAmount, BookingStatus bookingStatus) {
}
