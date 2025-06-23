package pe.edu.upc.travelmatch.geolocation.domain.model.commands;

import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.CityName;

public record UpdateCityCommand(CityName name, Long stateId) {
}
