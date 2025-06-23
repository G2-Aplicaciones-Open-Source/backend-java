package pe.edu.upc.travelmatch.bookings.domain.services;

import pe.edu.upc.travelmatch.bookings.domain.model.aggregates.Payout;
import pe.edu.upc.travelmatch.bookings.domain.model.queries.GetPayoutByIdQuery;
import pe.edu.upc.travelmatch.bookings.domain.model.queries.GetPayoutsByAgencyIdQuery;

import java.util.List;
import java.util.Optional;

public interface PayoutQueryService {
    Optional<Payout> handle(GetPayoutByIdQuery query);
    List<Payout> handle(GetPayoutsByAgencyIdQuery query);
}
