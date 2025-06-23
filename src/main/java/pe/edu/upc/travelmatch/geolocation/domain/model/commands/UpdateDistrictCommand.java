package pe.edu.upc.travelmatch.geolocation.domain.model.commands;

import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.DistrictName;

public record UpdateDistrictCommand(DistrictName name, Long districtId) {
}
