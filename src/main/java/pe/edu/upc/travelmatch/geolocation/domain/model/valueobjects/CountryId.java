package pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects;

public record CountryId (Long value) {
    public CountryId {
        if (value == null || value < 0)
            throw new IllegalArgumentException("CountryId must be a positive number");
    }

    public CountryId() {
        this(0L);
    }
}