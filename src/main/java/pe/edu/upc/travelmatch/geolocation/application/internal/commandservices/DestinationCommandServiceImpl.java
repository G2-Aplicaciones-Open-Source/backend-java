package pe.edu.upc.travelmatch.geolocation.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.travelmatch.geolocation.domain.model.aggregates.Destination;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.CreateDestinationCommand;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.UpdateDestinationCommand;
import pe.edu.upc.travelmatch.geolocation.domain.model.commands.DeleteDestinationCommand;
import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.DestinationName;
import pe.edu.upc.travelmatch.geolocation.domain.services.DestinationCommandService;
import pe.edu.upc.travelmatch.geolocation.infrastructure.persistence.jpa.repositories.DestinationRepository;

import java.util.Optional;

@Service
public class DestinationCommandServiceImpl implements DestinationCommandService {

    private final DestinationRepository destinationRepository;

    public DestinationCommandServiceImpl(DestinationRepository destinationRepository) { this.destinationRepository = destinationRepository;  }

    @Override
    public long handle(CreateDestinationCommand command) {
        var name = command.name();
        if (this.destinationRepository.existsByName(String.valueOf(name))) {
            throw new IllegalArgumentException("Destination with name " + name + " already exists");
        }
        var destination = new Destination(command);
        try {
            this.destinationRepository.save(destination);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving destination: " + e.getMessage());
        }
        return destination.getId();
    }

    @Override
    public Optional<Destination> handle(UpdateDestinationCommand command) {
        return Optional.empty();
    }
//@Override
    //public Optional<Destination> handle(UpdateDestinationCommand command) {
    //    var destinationIdId = command.destinationId();
    //    var fullName = command.fullName();
    //    if (this.destinationRepository.existsByFullNameAndIdIsNot(fullName, destinationIdId)) {
    //        throw new IllegalArgumentException("Profile with full name " + fullName + " already exists");
    //    }
//
    //    // If the profile does not exist, throw an exception
    //    if (!this.destinationRepository.existsById(destinationIdId)) {
    //        throw new IllegalArgumentException("Profile with id " + destinationIdId + " does not exist");
    //    }
//
    //    var destinationToUpdate = this.destinationRepository.findById(destinationIdId).get();
    //    destinationToUpdate.updateInformation(command.name(), command.age(), command.street());
//
    //    try {
    //        var updatedDestination = this.destinationRepository.save(destinationToUpdate);
    //        return Optional.of(updatedDestination);
    //    } catch (Exception e) {
    //        throw new IllegalArgumentException("Error while updating profile: " + e.getMessage());
    //    }
    //}

    @Override
    public void handle(DeleteDestinationCommand command) {
    // If the destination does not exist, throw an exception
        if (!this.destinationRepository.existsById(command.destinationId())) {
            throw new IllegalArgumentException("Destination with id " + command.destinationId() + " does not exist");
        }

        try {
            this.destinationRepository.deleteById(command.destinationId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting profile: " + e.getMessage());
        }
    }

}
