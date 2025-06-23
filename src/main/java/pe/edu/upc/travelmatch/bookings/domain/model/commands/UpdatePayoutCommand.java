package pe.edu.upc.travelmatch.bookings.domain.model.commands;

public record UpdatePayoutCommand(Long payoutId, int amount) {
}
