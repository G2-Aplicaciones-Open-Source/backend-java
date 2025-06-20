package pe.edu.upc.travelmatch.experiences.interfaces.rest.resources;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CreateAvailabilityResource(
        LocalDateTime startDateTime,
        LocalDateTime endDateTime,
        int capacity
) {}