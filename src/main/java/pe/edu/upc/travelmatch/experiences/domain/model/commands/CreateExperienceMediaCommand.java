package pe.edu.upc.travelmatch.experiences.domain.model.commands;


import java.util.Date;

public record CreateExperienceMediaCommand(
        Long experienceId,
        String mediaUrl,
        String caption
) {}