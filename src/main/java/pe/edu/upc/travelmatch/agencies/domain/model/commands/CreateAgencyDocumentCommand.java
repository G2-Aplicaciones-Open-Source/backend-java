package pe.edu.upc.travelmatch.agencies.domain.model.commands;

import jakarta.validation.constraints.NotNull;

public record CreateAgencyDocumentCommand(
        @NotNull Long agencyId,
        @NotNull String documentType,
        @NotNull String documentUrl,
        @NotNull String description
) {}