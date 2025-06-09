package pe.edu.upc.travelmatch.profiles.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upc.travelmatch.profiles.domain.model.aggregates.Cart;
import pe.edu.upc.travelmatch.profiles.domain.model.valueobjects.AvailabilityId;
import pe.edu.upc.travelmatch.profiles.domain.model.valueobjects.Money;
import pe.edu.upc.travelmatch.profiles.domain.model.valueobjects.Quantity;
import pe.edu.upc.travelmatch.shared.domain.model.entities.AuditableModel;

@Entity
@NoArgsConstructor
public class CartItem extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Getter
    private AvailabilityId availabilityId;

    @Embedded
    @Getter
    private Quantity quantity;

    @Embedded
    @Getter
    private Money price;

    @ManyToOne(fetch = FetchType.LAZY)
    @Setter
    private Cart cart;

    public CartItem( AvailabilityId availabilityId, Quantity quantity, Money price) {
        this.availabilityId = availabilityId;
        this.quantity = quantity;
        this.price = price;
    }
}
