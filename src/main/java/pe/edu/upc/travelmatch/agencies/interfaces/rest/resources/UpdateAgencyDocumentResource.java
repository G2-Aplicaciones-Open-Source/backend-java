package pe.edu.upc.travelmatch.agencies.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

public record UpdateAgencyDocumentResource(
        @NotNull Long id,
        @NotNull String documentType,
        @NotNull String documentUrl,
        String description
) {}