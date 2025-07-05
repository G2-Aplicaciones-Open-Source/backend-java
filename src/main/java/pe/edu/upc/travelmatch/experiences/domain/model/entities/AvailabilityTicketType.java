package pe.edu.upc.travelmatch.experiences.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upc.travelmatch.experiences.domain.model.aggregates.Availability;
import pe.edu.upc.travelmatch.experiences.domain.model.valueobjects.TicketType;
import pe.edu.upc.travelmatch.shared.domain.model.entities.AuditableModel;

import java.math.BigDecimal;

@Entity
@Table(name = "availability_ticket_types")
@NoArgsConstructor
public class AvailabilityTicketType extends AuditableModel {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "availability_id", nullable = false)
    @Getter
    @Setter
    private Availability availability;

    @Getter
    @Column(name = "ticket_type_id", nullable = false)
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

    public AvailabilityTicketType(Availability availability, Long ticketTypeId, TicketType ticketType, BigDecimal price, int stock) {
        this.availability = availability;
        this.ticketTypeId = ticketTypeId;
        this.ticketType = ticketType;
        this.price = price;
        this.stock = stock;
    }
}