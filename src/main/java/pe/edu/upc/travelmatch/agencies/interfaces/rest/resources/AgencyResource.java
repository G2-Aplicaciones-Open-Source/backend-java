package pe.edu.upc.travelmatch.agencies.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

public record AgencyResource(
        @NotNull Long id,
        @NotNull String name,
        @NotNull String description,
        @NotNull String ruc,
        @NotNull String contactEmail,
        @NotNull String contactPhone
) {}