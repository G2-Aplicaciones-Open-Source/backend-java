package pe.edu.upc.travelmatch.bookings.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record AgencyId(Long agencyId) {
    public AgencyId {
        if(agencyId < 0)
            throw new IllegalArgumentException("The agency id must be greater than zero");
    }
    public AgencyId(){
        this(0L);
    }
}
