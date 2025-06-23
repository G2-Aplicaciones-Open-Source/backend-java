package pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor
public class CountryInitials {
    private String name;

    public CountryInitials(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Country initials cannot be null or empty.");
        }
        if (name.length() != 3) {
            throw new IllegalArgumentException("Country initials must be exactly 3 letters.");
        }
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryInitials that = (CountryInitials) o;
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
