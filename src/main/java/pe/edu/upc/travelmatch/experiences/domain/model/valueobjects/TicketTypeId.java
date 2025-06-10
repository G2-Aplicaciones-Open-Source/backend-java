package pe.edu.upc.travelmatch.experiences.domain.model.valueobjects;

public record TicketTypeId(Long value) {
    public TicketTypeId {
        if (value == null || value < 0)
            throw new IllegalArgumentException("TicketTypeId must be a positive number");
    }

    public TicketTypeId() {
        this(0L);
    }
}