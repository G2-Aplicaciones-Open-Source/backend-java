package pe.edu.upc.travelmatch.geolocation.domain.model.commands;

import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.CountryName;

public record UpdateCountryCommand(CountryName name, Long stateId) {
}
