package pe.edu.upc.travelmatch.profiles.domain.model.valueobjects;

public record ExperienceId(Long experienceId) {
    public ExperienceId {
        if(experienceId < 0)
            throw new IllegalArgumentException("The experience id must be greater than zero");
    }
    public ExperienceId(){
        this(0L);
    }
}
