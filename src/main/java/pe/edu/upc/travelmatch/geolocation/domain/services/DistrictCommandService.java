package pe.edu.upc.travelmatch.geolocation.domain.services;

import pe.edu.upc.travelmatch.geolocation.domain.model.entities.City;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.CreateDistrictCommand;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.UpdateDistrictCommand;

import java.util.Optional;

public interface DistrictCommandService {
    long handle(CreateDistrictCommand command);
    Optional<City> handle(UpdateDistrictCommand command);
}
