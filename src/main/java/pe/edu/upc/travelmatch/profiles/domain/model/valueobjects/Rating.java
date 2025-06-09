package pe.edu.upc.travelmatch.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Rating(int value) {
    public Rating {
        if (value < 1 || value > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
    }

    public Rating() {
        this(1);
    }
}