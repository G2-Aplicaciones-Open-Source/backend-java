package pe.edu.upc.travelmatch.experiences.domain.model.commands;


public record CreateExperienceCommand(
        String title,
        String description,
        Long agencyId,
        Long categoryId,
        Long destinationId,
        String duration,
        String meetingPoint
) {}