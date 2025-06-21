package pe.edu.upc.travelmatch.experiences.domain.model.valueobjects;



public record ExperienceId(Long value) {
    public ExperienceId {
        if (value == null || value < 0)
            throw new IllegalArgumentException("ExperienceId must be a positive number");
    }

    public ExperienceId() {
        this(0L);
    }
}