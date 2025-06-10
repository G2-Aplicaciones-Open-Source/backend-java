package pe.edu.upc.travelmatch.iam.interfaces.acl;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import pe.edu.upc.travelmatch.iam.domain.model.commands.SignUpCommand;
import pe.edu.upc.travelmatch.iam.domain.model.entities.Role;
import pe.edu.upc.travelmatch.iam.domain.model.queries.GetUserByEmailQuery;
import pe.edu.upc.travelmatch.iam.domain.model.queries.GetUserByIdQuery;
import pe.edu.upc.travelmatch.iam.domain.services.UserCommandService;
import pe.edu.upc.travelmatch.iam.domain.services.UserQueryService;
import pe.edu.upc.travelmatch.iam.interfaces.rest.resources.UserResource;
import pe.edu.upc.travelmatch.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class IamContextFacade {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public IamContextFacade(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    public Long createUser(String email, String password, String firstName, String lastName, String phone) {
        var defaultRole = Role.toRoleFromName("ROLE_TOURIST");
        var signUpCommand = new SignUpCommand(email, password, firstName, lastName, phone,List.of(defaultRole));
        var result = userCommandService.handle(signUpCommand);
        if (result.isEmpty()) return 0L;
        return result.get().getId();
    }

    public Long createUser(String email, String password, String firstName, String lastName, String phone, List<String> roleNames) {
        if (roleNames == null) roleNames = new ArrayList<>();
        var roles = roleNames.stream()
                .map(Role::toRoleFromName)
                .toList();

        var signUpCommand = new SignUpCommand(email, password, firstName, lastName, phone, roles);
        var result = userCommandService.handle(signUpCommand);
        if (result.isEmpty()) return 0L;
        return result.get().getId();
    }

    public Optional<UserResource> fetchUserById(Long userId) {
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var result = userQueryService.handle(getUserByIdQuery);
        if(result.isEmpty()) return Optional.empty();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(result.get());
        return Optional.of(userResource);
    }

    public Long fetchUserIdByEmail(String email) {
        var getUserByEmailQuery = new GetUserByEmailQuery(email);
        var result = userQueryService.handle(getUserByEmailQuery);
        if (result.isEmpty()) return 0L;
        return result.get().getId();
    }

    public boolean existsUserByEmailAndIdIsNot(String email, Long id) {
        var getUserByEmailQuery = new GetUserByEmailQuery(email);
        var result = userQueryService.handle(getUserByEmailQuery);
        if (result.isEmpty()) return false;
        return !Objects.equals(result.get().getId(), id);
    }

    public String fetchEmailByUserId(Long userId) {
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var result = userQueryService.handle(getUserByIdQuery);
        if (result.isEmpty()) return Strings.EMPTY;
        return result.get().getEmail();
    }

}
