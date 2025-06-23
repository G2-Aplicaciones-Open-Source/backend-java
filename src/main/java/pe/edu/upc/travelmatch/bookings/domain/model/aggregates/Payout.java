package pe.edu.upc.travelmatch.bookings.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.AgencyId;
import pe.edu.upc.travelmatch.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.math.BigDecimal;

public class Payout extends AuditableAbstractAggregateRoot<Payout> {
    @Embedded
    @Getter
    @AttributeOverride(name="agencyId", column = @Column(name = "agency_id", nullable = false))
    private AgencyId agencyId;

    @Getter
    private BigDecimal amount;

    @Getter
    private String stripePayoutId;
}
