package pe.edu.upc.travelmatch.experiences.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.travelmatch.experiences.domain.model.aggregates.Availability;
import pe.edu.upc.travelmatch.experiences.domain.model.commands.CreateAvailabilityCommand;
import pe.edu.upc.travelmatch.experiences.domain.model.commands.CreateAvailabilityTicketTypeCommand;
import pe.edu.upc.travelmatch.experiences.domain.model.commands.UpdateAvailabilityCommand;
import pe.edu.upc.travelmatch.experiences.domain.services.AvailabilityCommandService;
import pe.edu.upc.travelmatch.experiences.domain.services.AvailabilityQueryService;
import pe.edu.upc.travelmatch.experiences.domain.services.AvailabilityTicketTypeCommandService;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.resources.*;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.transform.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Availabilities", description = "Availability Management Endpoints")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AvailabilitiesController {

    private final AvailabilityCommandService availabilityCommandService;
    private final AvailabilityQueryService availabilityQueryService;
    private final AvailabilityTicketTypeCommandService availabilityTicketTypeCommandService;

    public AvailabilitiesController(
            AvailabilityCommandService availabilityCommandService,
            AvailabilityQueryService availabilityQueryService,
            AvailabilityTicketTypeCommandService availabilityTicketTypeCommandService
    ) {
        this.availabilityCommandService = availabilityCommandService;
        this.availabilityQueryService = availabilityQueryService;
        this.availabilityTicketTypeCommandService = availabilityTicketTypeCommandService;
    }

    @PostMapping("/experiences/{experienceId}/availabilities")
    public ResponseEntity<Long> createAvailability(
            @PathVariable Long experienceId,
            @RequestBody CreateAvailabilityResource resource
    ) {
        CreateAvailabilityCommand command = new CreateAvailabilityCommand(
                experienceId,
                resource.startDateTime(),
                resource.endDateTime(),
                resource.capacity()
        );
        Long id = availabilityCommandService.handle(command);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/availabilities/{availabilityId}")
    public ResponseEntity<Void> updateAvailability(
            @PathVariable Long availabilityId,
            @RequestBody UpdateAvailabilityResource resource
    ) {
        UpdateAvailabilityCommand command = new UpdateAvailabilityCommand(
                availabilityId,
                resource.startDateTime(),
                resource.endDateTime(),
                resource.capacity()
        );
        availabilityCommandService.updateAvailability(command);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/availabilities/{availabilityId}")
    public ResponseEntity<Void> deleteAvailability(@PathVariable Long availabilityId) {
        availabilityCommandService.deleteAvailability(availabilityId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/availabilities")
    public ResponseEntity<List<AvailabilityResource>> getAllAvailabilities() {
        List<Availability> list = availabilityQueryService.getAllAvailabilities();
        var result = list.stream()
                .map(AvailabilityResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/availabilities/{availabilityId}/ticket-types")
    public ResponseEntity<Long> createTicketTypeForAvailability(
            @RequestBody CreateAvailabilityTicketTypeResource resource
    ) {
        CreateAvailabilityTicketTypeCommand command = CreateAvailabilityTicketTypeCommandFromResourceAssembler
                .toCommandFromResource(resource);
        Long id = availabilityTicketTypeCommandService.handle(command);
        return ResponseEntity.ok(id);
    }
}