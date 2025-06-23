package pe.edu.upc.travelmatch.bookings.domain.model.valueobjects;

public enum PaymentStatus {
    PENDING (1),
    SUCCEEDED (2),
    FAILED (3);

    private final int value;

    PaymentStatus(int value) {
        this.value = value;
    }
}
