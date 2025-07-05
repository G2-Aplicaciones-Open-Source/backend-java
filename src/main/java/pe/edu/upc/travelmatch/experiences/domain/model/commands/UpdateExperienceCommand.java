package pe.edu.upc.travelmatch.experiences.domain.model.commands;

import pe.edu.upc.travelmatch.experiences.domain.model.valueobjects.*;

public record UpdateExperienceCommand(
        Long id,
        String title,
        String description,
        Category category,
        DestinationId destinationId,
        String duration,
        String meetingPoint
) {}