package pe.edu.upc.travelmatch.bookings.domain.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.shared.domain.model.entities.AuditableModel;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class Refund extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long paymentId; // referencia a Payment

    private BigDecimal amount;

    private String stripeRefundId;

    // Getters y Setters (si no usas Lombok @Data)
}