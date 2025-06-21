package pe.edu.upc.travelmatch.agencies.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.upc.travelmatch.agencies.domain.model.valueobjects.AgencyName;
import pe.edu.upc.travelmatch.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Getter
@NoArgsConstructor
public class Agency extends AuditableAbstractAggregateRoot {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "agency_name"))
    })
    private AgencyName name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, unique = true)
    private String ruc;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String contactEmail;

    @Column(nullable = false)
    private String contactPhone;

    public Agency(AgencyName name, String description, String ruc, String address, String contactEmail, String contactPhone) {
        this.name = name;
        this.description = description;
        this.ruc = ruc;
        this.address = address;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    public void updateDetails(AgencyName name, String description, String address, String contactEmail, String contactPhone) {
        if (name != null) {
            this.name = name;
        }
        if (description != null) {
            this.description = description;
        }
        if (address != null) {
            this.address = address;
        }
        if (contactEmail != null) {
            this.contactEmail = contactEmail;
        }
        if (contactPhone != null) {
            this.contactPhone = contactPhone;
        }
    }

}