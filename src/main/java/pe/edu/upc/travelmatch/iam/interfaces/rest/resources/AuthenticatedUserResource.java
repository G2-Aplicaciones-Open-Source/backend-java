package pe.edu.upc.travelmatch.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String email, String token) {
}
