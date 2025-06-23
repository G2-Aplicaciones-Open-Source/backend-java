package pe.edu.upc.travelmatch.bookings.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.travelmatch.bookings.domain.model.entities.Payment;
import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.PaymentStatus;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByBookingId(Long bookingId);
    List<Payment> findByStatus(PaymentStatus status);
}
