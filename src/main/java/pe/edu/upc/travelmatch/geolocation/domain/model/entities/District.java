package pe.edu.upc.travelmatch.geolocation.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.DistrictName;
import pe.edu.upc.travelmatch.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Getter
@NoArgsConstructor
public class District extends AuditableAbstractAggregateRoot<District> {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "district_name"))
    })
    private DistrictName name;

    @Getter
    @Column(nullable = false)
    private Long cityId;

    public District(DistrictName name, Long cityId) {
        this.name = name;
        this.cityId = cityId;
    }

    public void updateDistrict(DistrictName name, Long cityId) {
        if (name != null) {
            this.name = name;
        }
        if (cityId != null) {
            this.cityId = cityId;
        }
    }
}
