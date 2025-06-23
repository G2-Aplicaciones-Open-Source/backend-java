package pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects;

public record StateId (Long value) {
    public StateId {
        if (value == null || value < 0)
            throw new IllegalArgumentException("StateId must be a positive number");
    }

    public StateId() {
        this(0L);
    }
}