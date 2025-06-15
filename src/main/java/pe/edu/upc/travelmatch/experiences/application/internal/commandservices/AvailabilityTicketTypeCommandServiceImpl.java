package pe.edu.upc.travelmatch.experiences.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.travelmatch.experiences.domain.model.commands.CreateAvailabilityTicketTypeCommand;
import pe.edu.upc.travelmatch.experiences.domain.model.entities.AvailabilityTicketType;
import pe.edu.upc.travelmatch.experiences.domain.services.AvailabilityTicketTypeCommandService;
import pe.edu.upc.travelmatch.experiences.infrastructure.persistence.jpa.repositories.AvailabilityRepository;
import pe.edu.upc.travelmatch.experiences.infrastructure.persistence.jpa.repositories.AvailabilityTicketTypeRepository;

@Service
public class AvailabilityTicketTypeCommandServiceImpl implements AvailabilityTicketTypeCommandService {

    private final AvailabilityTicketTypeRepository repository;
    private final AvailabilityRepository availabilityRepository;
    public AvailabilityTicketTypeCommandServiceImpl(AvailabilityTicketTypeRepository repository,
                                                    AvailabilityRepository availabilityRepository) {
        this.repository = repository;
        this.availabilityRepository = availabilityRepository;
    }

    @Override
    public Long handle(CreateAvailabilityTicketTypeCommand command) {
        if (!availabilityRepository.existsById(command.availabilityId())) {
            throw new IllegalArgumentException("Availability with ID " + command.availabilityId() + " does not exist.");
        }

        var ticketType = new AvailabilityTicketType(
                command.availabilityId(),
                command.ticketTypeId(),
                command.ticketType(), // ✅ nuevo parámetro
                command.price(),
                command.stock()
        );
        var saved = repository.save(ticketType);
        return saved.getId();
    }
}