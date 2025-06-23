package pe.edu.upc.travelmatch.geolocation.domain.services;

import pe.edu.upc.travelmatch.geolocation.domain.model.entities.City;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.CreateCityCommand;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.DeleteDestinationCommand;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.UpdateCityCommand;

import java.util.Optional;

public interface CityCommandService {
    long handle(CreateCityCommand command);
    Optional<City> handle(UpdateCityCommand command);
    void handle(DeleteDestinationCommand command);
}
