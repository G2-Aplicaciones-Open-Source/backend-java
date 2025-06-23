package pe.edu.upc.travelmatch.geolocation.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.CityName;
import pe.edu.upc.travelmatch.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Getter
@NoArgsConstructor
public class City extends AuditableAbstractAggregateRoot<City> {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "city_name"))
    })
    private CityName name;

    @Getter
    @Column(nullable = false)
    private Long stateId;

    public City(CityName name, Long stateId) {
        this.name = name;
        this.stateId = stateId;
    }

    public void updateDestination(CityName name, Long stateId) {
        if (name != null) {
            this.name = name;
        }
        if (stateId != null) {
            this.stateId = stateId;
        }
    }
}
