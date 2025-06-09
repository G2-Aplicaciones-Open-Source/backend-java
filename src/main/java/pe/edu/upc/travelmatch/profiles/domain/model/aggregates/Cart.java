package pe.edu.upc.travelmatch.profiles.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.profiles.domain.model.entities.CartItem;
import pe.edu.upc.travelmatch.profiles.domain.model.valueobjects.UserId;
import pe.edu.upc.travelmatch.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Cart extends AuditableAbstractAggregateRoot<Cart> {
    @Embedded
    @AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false, unique = true))
    private UserId userId;

    @Getter
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();

    public Cart(UserId userId) {
        this.userId = userId;
    }

    public void addItem(CartItem item) {
        boolean exists = items.stream()
                .anyMatch(existing -> existing.getAvailabilityId().equals(item.getAvailabilityId()));
        if (exists) {
            throw new IllegalStateException("This availability is already in the cart.");
        }
        item.setCart(this);
        this.items.add(item);
    }


    public void removeItem(CartItem item) {
        item.setCart(null);
        this.items.remove(item);
    }
}
