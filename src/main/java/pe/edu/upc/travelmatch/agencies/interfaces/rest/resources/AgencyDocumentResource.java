package pe.edu.upc.travelmatch.agencies.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

public record AgencyDocumentResource(
        @NotNull Long id,
        @NotNull Long agencyId,
        @NotNull String documentType,
        @NotNull String documentUrl,
        @NotNull String description
) {}