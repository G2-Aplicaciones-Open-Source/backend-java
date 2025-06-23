package pe.edu.upc.travelmatch.bookings.domain.model.commands;

public record CreatePaymentCommand(Long bookingId, String stripePaymentIntentId, int amount) {
}
