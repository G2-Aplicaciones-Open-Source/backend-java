package pe.edu.upc.travelmatch.geolocation.domain.model.commands;

import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.DestinationName;

public record CreateDestinationCommand(DestinationName name, Long districtId) {

}
