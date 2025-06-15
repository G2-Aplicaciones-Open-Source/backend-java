package pe.edu.upc.travelmatch.experiences.interfaces.rest.resources;

import java.time.LocalDate;

public record CreateAvailabilityResource(
        Long experienceId,
        LocalDate availableDate,
        int capacity
) {}