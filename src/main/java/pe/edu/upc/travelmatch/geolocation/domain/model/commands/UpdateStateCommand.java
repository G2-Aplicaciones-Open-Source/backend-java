package pe.edu.upc.travelmatch.geolocation.domain.model.commands;

import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.StateName;

public record UpdateStateCommand(StateName name, Long countryId) {
}
