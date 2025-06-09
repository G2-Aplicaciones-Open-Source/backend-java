package pe.edu.upc.travelmatch.profiles.domain.model.valueobjects;

public record Quantity(int value) {
    public Quantity {
        if(value < 0)
            throw new IllegalArgumentException("The quantity must be greater than zero");
    }
    public Quantity(){
        this(0);
    }
}
