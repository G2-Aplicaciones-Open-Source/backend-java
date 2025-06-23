package pe.edu.upc.travelmatch.geolocation.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.CountryInitials;
import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.CountryName;
import pe.edu.upc.travelmatch.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Getter
@NoArgsConstructor
public class Country extends AuditableAbstractAggregateRoot<Country> {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "country_name"))
    })
    private CountryName name;

    @Getter
    @Column(nullable = false)
    private CountryInitials countryInitials;

    public Country(CountryName name, CountryInitials countryInitials) {
        this.name = name;
        this.countryInitials = countryInitials;
    }

    public void updateDestination(CountryName name, CountryInitials countryInitials) {
        if (name != null) {
            this.name = name;
        }
        if (countryInitials != null) {
            this.countryInitials = countryInitials;
        }
    }
}
