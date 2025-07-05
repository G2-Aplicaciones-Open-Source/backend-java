package pe.edu.upc.travelmatch.bookings.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record TransactionId(String transactionId) {
    public TransactionId() { this(UUID.randomUUID().toString()); }

    public TransactionId {
        if (transactionId == null || transactionId.isBlank()) {
            throw new IllegalArgumentException("TransactionId cannot be null or blank");
        }
    }
}
