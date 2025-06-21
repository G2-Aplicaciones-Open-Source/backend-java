package pe.edu.upc.travelmatch.experiences.domain.model.valueobjects;

public record CategoryId(Long value) {
    public CategoryId {
        if (value == null || value < 0)
            throw new IllegalArgumentException("CategoryId must be a positive number");
    }

    public CategoryId() {
        this(0L);
    }
}