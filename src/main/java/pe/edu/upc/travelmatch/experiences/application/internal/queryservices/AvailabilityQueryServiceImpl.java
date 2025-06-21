package pe.edu.upc.travelmatch.experiences.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.travelmatch.experiences.domain.model.aggregates.Availability;
import pe.edu.upc.travelmatch.experiences.domain.services.AvailabilityQueryService;
import pe.edu.upc.travelmatch.experiences.infrastructure.persistence.jpa.repositories.AvailabilityRepository;

import java.util.List;

@Service
public class AvailabilityQueryServiceImpl implements AvailabilityQueryService {

    private final AvailabilityRepository availabilityRepository;

    public AvailabilityQueryServiceImpl(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    @Override
    public List<Availability> getAllAvailabilities() {
        return availabilityRepository.findAllByDeletedAtIsNull();
    }
}