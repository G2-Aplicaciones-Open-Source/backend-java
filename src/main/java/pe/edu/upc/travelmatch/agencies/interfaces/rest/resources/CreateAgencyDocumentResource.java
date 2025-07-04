package pe.edu.upc.travelmatch.agencies.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

public record CreateAgencyDocumentResource(
        @NotNull String documentType,
        @NotNull String documentUrl,
        @NotNull String description
) {}