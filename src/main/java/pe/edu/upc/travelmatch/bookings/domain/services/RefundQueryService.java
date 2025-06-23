package pe.edu.upc.travelmatch.bookings.domain.services;

import pe.edu.upc.travelmatch.bookings.domain.model.entities.Refund;
import pe.edu.upc.travelmatch.bookings.domain.model.queries.GetRefundByIdQuery;
import pe.edu.upc.travelmatch.bookings.domain.model.queries.GetRefundsByPaymentIdQuery;

import java.util.List;
import java.util.Optional;

public interface RefundQueryService {
    Optional<Refund> handle(GetRefundByIdQuery query);
    List<Refund> handle(GetRefundsByPaymentIdQuery query);
}
