package pe.edu.upc.travelmatch.bookings.domain.model.entities;

import jakarta.persistence.*;
import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.PaymentStatus;
import pe.edu.upc.travelmatch.shared.domain.model.entities.AuditableModel;

import java.math.BigDecimal;

public class Payment extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId; // referencia a Booking (aggregate root)

    private String stripePaymentIntentId;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    // Métodos de dominio
    public void markSucceeded() {
        this.status = PaymentStatus.SUCCEEDED;
    }

    public void markFailed() {
        this.status = PaymentStatus.FAILED;
    }

}
