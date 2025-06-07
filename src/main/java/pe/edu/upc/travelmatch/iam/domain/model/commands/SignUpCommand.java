package pe.edu.upc.travelmatch.iam.domain.model.commands;

import pe.edu.upc.travelmatch.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String email, String password, List<Role> role) {
}
