package pe.edu.upc.travelmatch.agencies.domain.model.commands;

import jakarta.validation.constraints.NotNull;

public record CreateAgencyCommand(
        @NotNull String name,
        @NotNull String description,
        @NotNull String ruc,
        @NotNull String contactEmail,
        @NotNull String contactPhone,
        @NotNull Long userId
) {}