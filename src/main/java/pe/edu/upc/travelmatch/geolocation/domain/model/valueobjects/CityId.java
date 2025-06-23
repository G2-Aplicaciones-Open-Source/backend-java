package pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects;

public record CityId (Long value) {
    public CityId {
        if (value == null || value < 0)
            throw new IllegalArgumentException("CityId must be a positive number");
    }

    public CityId() {
        this(0L);
    }
}