package pe.edu.upc.travelmatch.experiences.interfaces.rest.resources;


public record ExperienceResource(
        Long id,
        String title,
        String description,
        Long agencyId,
        Long categoryId,
        Long destinationId
) {}