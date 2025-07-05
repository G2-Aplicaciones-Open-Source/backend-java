package pe.edu.upc.travelmatch.bookings.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.travelmatch.bookings.application.internal.outboundservices.acl.ExternalExperienceService;
import pe.edu.upc.travelmatch.bookings.domain.model.aggregates.Booking;
import pe.edu.upc.travelmatch.bookings.domain.model.commands.*;
import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.AvailabilityId;
import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.BookingStatus;
import pe.edu.upc.travelmatch.bookings.domain.model.valueobjects.UserId;
import pe.edu.upc.travelmatch.bookings.domain.services.BookingCommandService;
import pe.edu.upc.travelmatch.bookings.infrastructure.persistence.jpa.repositories.BookingRepository;

import java.util.Optional;

@Service
public class BookingCommandServiceImpl implements BookingCommandService {
    private final BookingRepository bookingRepository;
    private final ExternalExperienceService externalExperienceService;
    public BookingCommandServiceImpl(
            BookingRepository bookingRepository,
            ExternalExperienceService externalExperienceService
    ) {
        this.bookingRepository = bookingRepository;
        this.externalExperienceService = externalExperienceService;
    }


    @Override
    public Long handle(CreateBookingCommand command) {
        if(!externalExperienceService.existsAvailabilityById(command.availabilityId()))
            throw new IllegalArgumentException("Availability with id " + command.availabilityId() + " does not exist.");

        var booking = new Booking(
                command.userId(),
                command.availabilityId(),
                totalPrice,
                command.quantity(),
                BookingStatus.PENDING,
                command.bookingDate()
        );
        bookingRepository.save(booking);
        return booking.getId();
    }

    @Override
    public Optional<Booking> handle(CancelBookingCommand command) {
        return Optional.empty();
    }

    @Override
    public Long handle(ProcessPaymentCommand command) {
        return 0L;
    }

    @Override
    public boolean handle(FailPaymentCommand command) {
        return false;
    }

    @Override
    public Long handle(ProcessPayoutCommand command) {
        return 0L;
    }

    @Override
    public boolean handle(CompletePayoutCommand command) {
        return false;
    }

    @Override
    public Long handle(InitiateRefundCommand command) {
        return 0L;
    }
}
