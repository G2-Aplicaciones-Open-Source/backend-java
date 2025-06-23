package pe.edu.upc.travelmatch.bookings.domain.model.valueobjects;

public enum BookingStatus {
    PENDING (1),
    SUCCEEDED (2),
    FAILED (3);

    private final int value;

    BookingStatus(int value) {
        this.value = value;
    }
}
