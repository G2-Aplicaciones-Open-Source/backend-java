package pe.edu.upc.travelmatch.experiences.domain.model.commands;

public record UpdateExperienceCommand(
        Long experienceId,
        String title,
        String description,
        Long categoryId,
        Long destinationId,
        String duration,
        String meetingPoint
) {}