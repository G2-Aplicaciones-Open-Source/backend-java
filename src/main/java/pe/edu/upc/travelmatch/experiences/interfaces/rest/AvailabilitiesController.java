package pe.edu.upc.travelmatch.experiences.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.travelmatch.experiences.domain.model.commands.CreateAvailabilityCommand;
import pe.edu.upc.travelmatch.experiences.domain.model.commands.CreateAvailabilityTicketTypeCommand;
import pe.edu.upc.travelmatch.experiences.domain.services.AvailabilityCommandService;
import pe.edu.upc.travelmatch.experiences.domain.services.AvailabilityTicketTypeCommandService;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.resources.CreateAvailabilityResource;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.resources.CreateAvailabilityTicketTypeResource;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.transform.CreateAvailabilityCommandFromResourceAssembler;
import pe.edu.upc.travelmatch.experiences.interfaces.rest.transform.CreateAvailabilityTicketTypeCommandFromResourceAssembler;

@RestController
@RequestMapping("/api/v1/availabilities")
@Tag(name = "Availabilities", description = "Availability Management Endpoints")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class AvailabilitiesController {

    private final AvailabilityCommandService availabilityCommandService;
    private final AvailabilityTicketTypeCommandService availabilityTicketTypeCommandService;

    public AvailabilitiesController(
            AvailabilityCommandService availabilityCommandService,
            AvailabilityTicketTypeCommandService availabilityTicketTypeCommandService
    ) {
        this.availabilityCommandService = availabilityCommandService;
        this.availabilityTicketTypeCommandService = availabilityTicketTypeCommandService;
    }

    @PostMapping
    public ResponseEntity<Long> createAvailability(@RequestBody CreateAvailabilityResource resource) {
        CreateAvailabilityCommand command = CreateAvailabilityCommandFromResourceAssembler.toCommandFromResource(resource);
        Long id = availabilityCommandService.handle(command);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/{availabilityId}/ticket-types")
    public ResponseEntity<Long> createTicketTypeForAvailability(
            @RequestBody CreateAvailabilityTicketTypeResource resource
    ) {
        CreateAvailabilityTicketTypeCommand command = CreateAvailabilityTicketTypeCommandFromResourceAssembler
                .toCommandFromResource(resource);
        Long id = availabilityTicketTypeCommandService.handle(command);
        return ResponseEntity.ok(id);
    }
}