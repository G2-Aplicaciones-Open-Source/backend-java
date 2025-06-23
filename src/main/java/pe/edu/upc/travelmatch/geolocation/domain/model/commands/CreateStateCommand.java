package pe.edu.upc.travelmatch.geolocation.domain.model.commands;

import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.StateName;

public record CreateStateCommand(StateName name, Long countryId) {
}
