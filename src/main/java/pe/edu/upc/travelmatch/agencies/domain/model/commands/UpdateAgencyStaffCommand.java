package pe.edu.upc.travelmatch.agencies.domain.model.commands;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdateAgencyStaffCommand(
        @NotNull Long id,
        @NotNull String firstName,
        @NotNull String lastName,
        @NotNull @Email String email,
        @NotNull @Pattern(regexp = "\\d{9}", message = "Phone must be 9 digits") String phone,
        @NotNull String position
) {}