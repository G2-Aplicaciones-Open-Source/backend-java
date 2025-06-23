package pe.edu.upc.travelmatch.bookings.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.travelmatch.bookings.domain.model.entities.PayoutBooking;

import java.util.List;

@Repository
public interface PayoutBookingRepository extends JpaRepository<PayoutBooking, Long> {
    List<PayoutBooking> findByBookingId(Long bookingId);
    List<PayoutBooking> findByPayoutId(Long payoutId);
}
