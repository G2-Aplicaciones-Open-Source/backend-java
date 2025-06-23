package pe.edu.upc.travelmatch.geolocation.domain.model.commands;

import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.DistrictName;

public record CreateDistrictCommand(DistrictName name, Long districtId) {
}
