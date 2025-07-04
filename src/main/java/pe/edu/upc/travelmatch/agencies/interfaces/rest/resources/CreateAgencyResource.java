package pe.edu.upc.travelmatch.agencies.interfaces.rest.resources;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateAgencyResource(
        @NotNull String name,
        @NotNull String description,
        @NotNull @Pattern(regexp = "\\d{11}", message = "RUC must be 11 digits") String ruc,
        @NotNull @Email String contactEmail,
        @NotNull @Pattern(regexp = "\\d{9}", message = "Contact phone must be 9 digits") String contactPhone,
        @NotNull Long userId
) {}