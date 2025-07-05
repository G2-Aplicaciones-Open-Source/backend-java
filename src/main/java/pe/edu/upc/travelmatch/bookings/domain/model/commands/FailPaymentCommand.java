package pe.edu.upc.travelmatch.bookings.domain.model.commands;

import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.TransactionId;

public record FailPaymentCommand(
        Long bookingId,
        TransactionId transactionId,
        String reason
) { }
