package pe.edu.upc.travelmatch.experiences.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.travelmatch.experiences.domain.model.commands.CreateExperienceCommand;
import pe.edu.upc.travelmatch.experiences.domain.model.queries.GetAllExperiencesQuery;
import pe.edu.upc.travelmatch.experiences.domain.model.queries.GetExperienceByIdQuery;
import pe.edu.upc.travelmatch.experiences.domain.services.ExperienceCommandService;
import pe.edu.upc.travelmatch.experiences.domain.services.ExperienceQueryService;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.resources.CreateExperienceResource;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.resources.ExperienceResource;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.transform.CreateExperienceCommandFromResourceAssembler;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.transform.ExperienceResourceFromEntityAssembler;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping(value = "/api/v1/experiences")
@Tag(name = "Experiences", description = "Experiences Management Endpoints")
public class ExperiencesController {

    private final ExperienceCommandService commandService;
    private final ExperienceQueryService queryService;

    public ExperiencesController(ExperienceCommandService commandService, ExperienceQueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping
    public ResponseEntity<ExperienceResource> createExperience(@RequestBody CreateExperienceResource resource) {
        CreateExperienceCommand command = CreateExperienceCommandFromResourceAssembler.toCommandFromResource(resource);
        Long id = commandService.handle(command);
        Optional<ExperienceResource> created = queryService.handle(new GetExperienceByIdQuery(id))
                .map(ExperienceResourceFromEntityAssembler::toResourceFromEntity);

        return created.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<ExperienceResource>> getAllExperiences() {
        var query = new GetAllExperiencesQuery();
        var result = queryService.handle(query);
        var resources = result.stream()
                .map(ExperienceResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resources);
    }
}