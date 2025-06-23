package pe.edu.upc.travelmatch.geolocation.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.StateName;
import pe.edu.upc.travelmatch.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Getter
@NoArgsConstructor
public class State extends AuditableAbstractAggregateRoot<State>{
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "state_name"))
    })
    private StateName name;

    @Getter
    @Column(nullable = false)
    private Long countryId;

    public State(StateName name, Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public void updateDestination(StateName name, Long countryId) {
        if (name != null) {
            this.name = name;
        }
        if (countryId != null) {
            this.countryId = countryId;
        }
    }

}
