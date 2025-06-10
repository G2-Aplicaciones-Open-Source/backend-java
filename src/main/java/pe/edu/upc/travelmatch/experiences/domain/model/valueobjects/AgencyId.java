package pe.edu.upc.travelmatch.experiences.domain.model.valueobjects;

public record AgencyId(Long value) {
    public AgencyId {
        if (value == null || value < 0)
            throw new IllegalArgumentException("AgencyId must be a positive number");
    }

    public AgencyId() {
        this(0L);
    }
}