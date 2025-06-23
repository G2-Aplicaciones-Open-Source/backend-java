package pe.edu.upc.travelmatch.bookings.domain.model.commands;

public record UpdateBookingCommand(Long bookingId, int quantity, double totalAmount) {
}
