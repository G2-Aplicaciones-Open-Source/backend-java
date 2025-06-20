package pe.edu.upc.travelmatch.experiences.domain.services;

import pe.edu.upc.travelmatch.experiences.domain.model.aggregates.Availability;

import java.util.List;

public interface AvailabilityQueryService {
    List<Availability> getAllAvailabilities();
}