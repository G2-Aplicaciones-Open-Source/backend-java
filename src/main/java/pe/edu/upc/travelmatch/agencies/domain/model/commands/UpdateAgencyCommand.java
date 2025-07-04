package pe.edu.upc.travelmatch.agencies.domain.model.commands;

import jakarta.validation.constraints.NotNull;

public record UpdateAgencyCommand(
        @NotNull Long agencyId,
        @NotNull String name,
        @NotNull String description,
        @NotNull String contactEmail,
        @NotNull String contactPhone
) {}