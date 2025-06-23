package pe.edu.upc.travelmatch.geolocation.domain.services;

import pe.edu.upc.travelmatch.geolocation.domain.model.entities.State;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.CreateStateCommand;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.UpdateStateCommand;

import java.util.Optional;

public interface StateCommandService {
    long handle(CreateStateCommand command);
    Optional<State> handle(UpdateStateCommand command);
}
