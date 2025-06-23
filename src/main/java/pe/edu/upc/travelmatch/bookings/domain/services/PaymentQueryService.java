package pe.edu.upc.travelmatch.bookings.domain.services;

import pe.edu.upc.travelmatch.bookings.domain.model.entities.Payment;
import pe.edu.upc.travelmatch.bookings.domain.model.queries.GetPaymentByIdQuery;
import pe.edu.upc.travelmatch.bookings.domain.model.queries.GetPaymentsByBookingIdQuery;
import pe.edu.upc.travelmatch.bookings.domain.model.queries.GetPaymentsByStatusQuery;

import java.util.List;
import java.util.Optional;

public interface PaymentQueryService {
    Optional<Payment> handle(GetPaymentByIdQuery query);
    List<Payment> handle(GetPaymentsByBookingIdQuery query);
    List<Payment> handle(GetPaymentsByStatusQuery query);
}
