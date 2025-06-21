package pe.edu.upc.travelmatch.experiences.domain.model.commands;


import java.time.LocalDate;
import java.time.LocalDateTime;

public record CreateAvailabilityCommand(
        Long experienceId,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime,
        int capacity
) {}