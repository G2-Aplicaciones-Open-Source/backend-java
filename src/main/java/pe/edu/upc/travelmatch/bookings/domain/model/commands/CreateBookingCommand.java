package pe.edu.upc.travelmatch.bookings.domain.model.commands;

import java.time.Instant;

public record CreateBookingCommand(
        Long userId,
        Long availabilityId,
        int quantity,
        Instant bookingDate
) { }
