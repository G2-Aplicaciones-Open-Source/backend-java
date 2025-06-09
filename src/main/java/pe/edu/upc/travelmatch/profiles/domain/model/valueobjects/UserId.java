package pe.edu.upc.travelmatch.profiles.domain.model.valueobjects;

public record UserId(Long userId) {
    public UserId {
        if(userId < 0)
            throw new IllegalArgumentException("The user id must be greater than zero");
    }
    public UserId(){
        this(0L);
    }
}
