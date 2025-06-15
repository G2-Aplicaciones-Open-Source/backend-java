package pe.edu.upc.travelmatch.profiles.domain.services;

import pe.edu.upc.travelmatch.profiles.domain.model.commands.CreateReviewCommand;
import pe.edu.upc.travelmatch.profiles.domain.model.commands.DeleteReviewCommand;
import pe.edu.upc.travelmatch.profiles.domain.model.commands.UpdateReviewCommand;

public interface ReviewCommandService {
    void handle(CreateReviewCommand command);
    void handle(UpdateReviewCommand command);
    void handle(DeleteReviewCommand command);
}
