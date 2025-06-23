package pe.edu.upc.travelmatch.bookings.domain.model.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.shared.domain.model.entities.AuditableModel;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class PayoutBooking extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId; // referencia a Booking (aggregate root)

    private Long payoutId;  // referencia a Payout (aggregate root)

    private BigDecimal comissionPct;
    private BigDecimal comissionAmt;
    private BigDecimal agencyEarnings;
}
