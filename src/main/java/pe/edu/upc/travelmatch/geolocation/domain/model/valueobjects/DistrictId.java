package pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects;

public record DistrictId (Long value) {
    public DistrictId {
        if (value == null || value < 0)
            throw new IllegalArgumentException("DistrictId must be a positive number");
    }

    public DistrictId() {
        this(0L);
    }
}