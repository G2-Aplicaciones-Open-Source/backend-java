package pe.edu.upc.travelmatch.bookings.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.travelmatch.bookings.domain.model.aggregates.Payout;
import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.AgencyId;

import java.util.List;

@Repository
public interface PayoutRepository extends JpaRepository<Payout, Long> {
    List<Payout> findByAgencyId(AgencyId agencyId);
}
