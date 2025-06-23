package pe.edu.upc.travelmatch.bookings.domain.model.queries;

import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.PaymentStatus;

public record GetPaymentsByStatusQuery(PaymentStatus status) {
}
