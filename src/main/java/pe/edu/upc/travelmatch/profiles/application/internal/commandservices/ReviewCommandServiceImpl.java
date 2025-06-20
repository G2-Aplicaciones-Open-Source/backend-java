package pe.edu.upc.travelmatch.profiles.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.travelmatch.profiles.application.internal.outboundservices.acl.ExternalIamService;
import pe.edu.upc.travelmatch.profiles.domain.model.aggregates.Review;
import pe.edu.upc.travelmatch.profiles.domain.model.commands.CreateReviewCommand;
import pe.edu.upc.travelmatch.profiles.domain.model.commands.DeleteReviewCommand;
import pe.edu.upc.travelmatch.profiles.domain.model.commands.UpdateReviewCommand;
import pe.edu.upc.travelmatch.profiles.domain.services.ReviewCommandService;
import pe.edu.upc.travelmatch.profiles.infrastructure.persistence.jpa.repositories.ReviewRepository;

import java.util.Optional;

@Service
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final ExternalIamService externalIamService;
//    private final ExternalExperiencesService externalExperiencesService;

    public ReviewCommandServiceImpl(ReviewRepository reviewRepository,
                                    ExternalIamService externalIamService) {
        this.reviewRepository = reviewRepository;
        this.externalIamService = externalIamService;
    }

    @Override
    public Long handle(CreateReviewCommand command) {
        if(!externalIamService.existsUserById(command.userId()))
            throw new IllegalArgumentException("User with id " + command.userId().userId()+ " not found");
        var review = new Review(command.userId(), command.experienceId(), command.rating(), command.comment());
        reviewRepository.save(review);
        return review.getId();
    }

    @Override
    public Optional<Review> handle(UpdateReviewCommand command) {
        return Optional.empty();
    }

    @Override
    public void handle(DeleteReviewCommand command) {

    }
}
