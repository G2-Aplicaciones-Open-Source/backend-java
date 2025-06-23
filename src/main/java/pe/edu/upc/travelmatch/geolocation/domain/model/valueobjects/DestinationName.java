package pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor
public class DestinationName {
    private String name;

    public DestinationName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Destination name cannot be null or empty.");
        }
        this.name = name;
    }

    public DestinationName(DestinationName name) {
        if (name == null) {
            throw new IllegalArgumentException("Destination name cannot be null.");
        }
        this.name = name.getName();
    }

    @Override
    public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         DestinationName that = (DestinationName) o;
         return Objects.equals(name, that.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
