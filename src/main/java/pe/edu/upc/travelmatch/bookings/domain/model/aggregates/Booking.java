package pe.edu.upc.travelmatch.bookings.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.BookingStatus;
import pe.edu.upc.travelmatch.profiles.domain.model.valueobjects.AvailabilityId;
import pe.edu.upc.travelmatch.profiles.domain.model.valueobjects.UserId;
import pe.edu.upc.travelmatch.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class Booking extends AuditableAbstractAggregateRoot<Booking> {

    @Embedded
    @Getter
    @AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false))
    private UserId userId;

    @Embedded
    @Getter
    @AttributeOverride(name = "availabilityId", column = @Column(name = "availability_id", nullable = false))
    private AvailabilityId availabilityId;

    @Getter
    private int quantity;

    @Getter
    private BigDecimal totalAmount;

    @Embedded
    @Getter
    private BookingStatus bookingStatus;
}
