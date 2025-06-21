package pe.edu.upc.travelmatch.experiences.domain.model.valueobjects;

public record UserId(Long value) {
    public UserId {
        if (value == null || value < 0)
            throw new IllegalArgumentException("UserId must be a positive number");
    }

    public UserId() {
        this(0L);
    }
}