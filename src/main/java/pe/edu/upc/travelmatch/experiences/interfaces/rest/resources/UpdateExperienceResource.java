package pe.edu.upc.travelmatch.experiences.interfaces.rest.resources;

public record UpdateExperienceResource(
        String title,
        String description,
        Long categoryId,
        Long destinationId,
        String duration,
        String meetingPoint
) {}