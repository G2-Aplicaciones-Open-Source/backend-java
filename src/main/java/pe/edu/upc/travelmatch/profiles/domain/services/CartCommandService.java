package pe.edu.upc.travelmatch.profiles.domain.services;

import pe.edu.upc.travelmatch.profiles.domain.model.commands.AddCartItemCommand;
import pe.edu.upc.travelmatch.profiles.domain.model.commands.CreateCartCommand;
import pe.edu.upc.travelmatch.profiles.domain.model.commands.RemoveCartItemCommand;

public interface CartCommandService {
    void handle(CreateCartCommand command);
    void handle(AddCartItemCommand command);
    void handle(RemoveCartItemCommand command);
}
