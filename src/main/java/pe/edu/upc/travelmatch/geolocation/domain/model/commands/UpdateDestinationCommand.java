package pe.edu.upc.travelmatch.geolocation.domain.model.commands;

import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.DestinationName;

public record UpdateDestinationCommand(DestinationName name, Long districtId) {
}
