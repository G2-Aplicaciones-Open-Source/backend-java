package pe.edu.upc.travelmatch.geolocation.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.CreateDestinationCommand;
import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.DestinationName;
import pe.edu.upc.travelmatch.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Getter
@NoArgsConstructor
public class Destination extends AuditableAbstractAggregateRoot<Destination> {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "destination_name"))
    })
    private DestinationName name;

    @Getter
    @Column(nullable = false)
    private Long districtId;

    public Destination(DestinationName name, Long districtId) {
        this.name = name;
        this.districtId = districtId;
    }

    public Destination(CreateDestinationCommand command) {
        this.name = new DestinationName(command.name());
        this.districtId = command.districtId();
    }

    public void updateDestination(DestinationName name, Long districtId) {
        if (name != null) {
            this.name = name;
        }
        if (districtId != null) {
            this.districtId = districtId;
        }
    }

}
