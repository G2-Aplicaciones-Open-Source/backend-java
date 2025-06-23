package pe.edu.upc.travelmatch.bookings.application.internal.queryservices;

import pe.edu.upc.travelmatch.bookings.domain.model.queries.GetPaymentByIdQuery;
import pe.edu.upc.travelmatch.bookings.domain.services.PaymentQueryService;
import pe.edu.upc.travelmatch.bookings.infrastructure.persistence.jpa.repositories.PaymentRepository;

public class PaymentQueryServiceImpl implements PaymentQueryService {
    private final PaymentRepository paymentRepository;

    public PaymentQueryService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Optional<Payment> handle(GetPaymentByIdQuery query) {
        return paymentRepository.findById(query.paymentId());
    }

    public List<Payment> handle(GetPaymentsByBookingIdQuery query) {
        return paymentRepository.findByBookingId(query.bookingId());
    }

    public List<Payment> handle(GetPaymentsByStatusQuery query) {
        return paymentRepository.findByStatus(query.status());
    }
}
