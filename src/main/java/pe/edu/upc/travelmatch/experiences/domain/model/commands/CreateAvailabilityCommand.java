package pe.edu.upc.travelmatch.experiences.domain.model.commands;


import java.time.LocalDate;

public record CreateAvailabilityCommand(
        Long experienceId,
        LocalDate availableDate,
        int capacity
) {}