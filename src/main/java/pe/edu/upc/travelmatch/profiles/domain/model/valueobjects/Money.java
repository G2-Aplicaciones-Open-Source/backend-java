package pe.edu.upc.travelmatch.profiles.domain.model.valueobjects;

import java.math.BigDecimal;
import java.util.Objects;

public record Money(BigDecimal value, String currency) {

    public Money {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The money value must be greater than or equal to zero");
        }
        if (currency == null || currency.isEmpty()) {
            throw new IllegalArgumentException("Currency must not be null or empty");
        }
    }

    public Money() {
        this(BigDecimal.ZERO, "PEN");
    }

    public static Money zero() {
        return new Money(BigDecimal.ZERO, "PEN");
    }

    public Money add(Money other) {
        Objects.requireNonNull(other, "The other Money object must not be null");
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currency mismatch: cannot add Money with different currencies");
        }
        return new Money(this.value.add(other.value), this.currency);
    }

    public Money multiply(int multiplier) {
        if (multiplier < 0) {
            throw new IllegalArgumentException("Multiplier must be greater than or equal to zero");
        }
        return new Money(this.value.multiply(BigDecimal.valueOf(multiplier)), this.currency);
    }

    public Money multiply(BigDecimal multiplier) {
        if (multiplier == null || multiplier.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Multiplier must not be null and must be greater than or equal to zero");
        }
        return new Money(this.value.multiply(multiplier), this.currency);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.value, this.currency);
    }
}