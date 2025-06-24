package pe.edu.upc.travelmatch.experiences.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
import pe.edu.upc.travelmatch.experiences.interfaces.rest.resources.UpdateExperienceResource;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.transform.CreateExperienceCommandFromResourceAssembler;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.transform.ExperienceResourceFromEntityAssembler;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.transform.UpdateExperienceCommandFromResourceAssembler;

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



    @Operation(
            summary = "Create a new experience",
            description = "Creates a new experience linked to a specific agency",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Experience created successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid request data")
            }
    )
    @PostMapping("/{agencyId}/experiences")
    public ResponseEntity<ExperienceResource> createExperience(
            @PathVariable Long agencyId,
            @RequestBody CreateExperienceResource resource
    ) {
        // Usamos agencyId del path en lugar del que venga en el body
        CreateExperienceCommand command =
                CreateExperienceCommandFromResourceAssembler.toCommandFromResource(resource, agencyId);

        Long id = commandService.handle(command);
        Optional<ExperienceResource> created = queryService
                .handle(new GetExperienceByIdQuery(id))
                .map(ExperienceResourceFromEntityAssembler::toResourceFromEntity);

        return created.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @Operation(
            summary = "Get all experiences",
            description = "Retrieves all experiences stored in the system",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of experiences returned")
            }
    )
    @GetMapping
    public ResponseEntity<List<ExperienceResource>> getAllExperiences() {
        var query = new GetAllExperiencesQuery();
        var result = queryService.handle(query);
        var resources = result.stream()
                .map(ExperienceResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resources);
    }


    @Operation(
            summary = "Update an experience",
            description = "Updates an existing experience by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Experience updated successfully"),
                    @ApiResponse(responseCode = "404", description = "Experience not found")
            }
    )
    @PutMapping("/{experienceId}")
    public ResponseEntity<ExperienceResource> updateExperience(
            @PathVariable Long experienceId,
            @RequestBody UpdateExperienceResource resource
    ) {
        var command = UpdateExperienceCommandFromResourceAssembler.toCommandFromResource(resource, experienceId);
        commandService.updateExperience(command);

        var updated = queryService.handle(new GetExperienceByIdQuery(experienceId))
                .map(ExperienceResourceFromEntityAssembler::toResourceFromEntity);

        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @Operation(
            summary = "Delete an experience",
            description = "Logically deletes an experience by setting deletedAt",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Experience deleted successfully")
            }
    )
    @DeleteMapping("/{experienceId}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long experienceId) {
        commandService.deleteExperience(experienceId);
        return ResponseEntity.noContent().build();
    }
}