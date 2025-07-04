package pe.edu.upc.travelmatch.agencies.domain.model.commands;

import jakarta.validation.constraints.NotNull;

public record UpdateAgencyDocumentCommand(
        @NotNull Long id,
        @NotNull String documentType,
        @NotNull String documentUrl,
        @NotNull String description
) {}