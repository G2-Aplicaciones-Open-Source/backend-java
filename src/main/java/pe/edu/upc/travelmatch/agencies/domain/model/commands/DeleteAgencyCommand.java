package pe.edu.upc.travelmatch.agencies.domain.model.commands;

import jakarta.validation.constraints.NotNull;

public record DeleteAgencyCommand(
        @NotNull Long agencyId
) {}