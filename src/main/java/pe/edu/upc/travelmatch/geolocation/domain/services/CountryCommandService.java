package pe.edu.upc.travelmatch.geolocation.domain.services;

import pe.edu.upc.travelmatch.geolocation.domain.model.entities.Country;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.CreateCountryCommand;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.UpdateCountryCommand;

import java.util.Optional;

public interface CountryCommandService {
    long handle(CreateCountryCommand command);
    Optional<Country> handle(UpdateCountryCommand command);
}
