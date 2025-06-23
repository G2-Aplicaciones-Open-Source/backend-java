package pe.edu.upc.travelmatch.bookings.domain.services;

import pe.edu.upc.travelmatch.bookings.domain.model.entities.PayoutBooking;
import pe.edu.upc.travelmatch.bookings.domain.model.queries.GetPayoutBookingsByBookingIdQuery;
import pe.edu.upc.travelmatch.bookings.domain.model.queries.GetPayoutBookingsByPayoutIdQuery;

import java.util.List;

public interface PayoutBookingQueryService {
    List<PayoutBooking> handle(GetPayoutBookingsByBookingIdQuery query);
    List<PayoutBooking> handle(GetPayoutBookingsByPayoutIdQuery query);
}
