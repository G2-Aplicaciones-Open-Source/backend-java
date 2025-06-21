package pe.edu.upc.travelmatch.experiences.domain.model.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.travelmatch.experiences.domain.model.valueobjects.TicketType;
import java.math.BigDecimal;


@Entity
@Table(name = "availability_ticket_types")
@NoArgsConstructor
public class AvailabilityTicketType extends AuditableModel {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(nullable = false)
    private Long availabilityId;

    @Getter
    @Column(nullable = false)
    private Long ticketTypeId;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketType ticketType;

    @Getter
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Getter
    @Column(nullable = false)
    private int stock;

    public AvailabilityTicketType(Long availabilityId, Long ticketTypeId, TicketType ticketType, BigDecimal price, int stock) {
        this.availabilityId = availabilityId;
        this.ticketTypeId = ticketTypeId;
        this.ticketType = ticketType;
        this.price = price;
        this.stock = stock;
    }
}