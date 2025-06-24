package pe.edu.upc.travelmatch.geolocationv2.domain.model.commands;

public record CreateDestinationCommand(String name, String address, String district, String state, String country) {
}
