package pe.edu.upc.travelmatch.experiences.infrastructure.persistence.jpa.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.travelmatch.experiences.domain.model.entities.AvailabilityTicketType;

import java.util.List;

@Repository
public interface AvailabilityTicketTypeRepository extends JpaRepository<AvailabilityTicketType, Long> {
    List<AvailabilityTicketType> findByAvailabilityId(Long availabilityId);
}