package pe.edu.upc.travelmatch.geolocation.domain.services;

import pe.edu.upc.travelmatch.geolocation.domain.model.aggregates.Destination;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.CreateDestinationCommand;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.DeleteDestinationCommand;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.UpdateDestinationCommand;

import java.util.Optional;

public interface DestinationCommandService {

    long handle(CreateDestinationCommand command);
    Optional<Destination> handle(UpdateDestinationCommand command);
    void handle(DeleteDestinationCommand command);

}
