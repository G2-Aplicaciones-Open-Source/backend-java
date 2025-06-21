package pe.edu.upc.travelmatch.agencies.domain.model.commands;

public record CreateAgencyCommand(
        String name,
        String description,
        String ruc,
        String address,
        String contactEmail,
        String contactPhone
) {}