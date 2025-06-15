package pe.edu.upc.travelmatch.experiences.domain.model.valueobjects;

public record DestinationId(Long value) {
    public DestinationId {
        if (value == null || value < 0)
            throw new IllegalArgumentException("DestinationId must be a positive number");
    }

    public DestinationId() {
        this(0L);
    }
}