package br.com.fiap.parquimetro.application.service.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.parquimetro.domain.dto.request.VehicleRequestDTO;
import br.com.fiap.parquimetro.domain.dto.response.SearchAllVehiclesResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.VehicleResponseDTO;
import br.com.fiap.parquimetro.domain.entity.VehicleEntity;

public class VehicleMapper {

	public static VehicleEntity mapVehicleEntity(VehicleRequestDTO request) {
		var entity = new VehicleEntity();
		entity.setModel(request.getModel());
		entity.setBrand(request.getBrand());
		entity.setYearFabrication(request.getYearFabrication());
		entity.setPlate(request.getPlate());
		return entity;
	}
	
	public static SearchAllVehiclesResponseDTO mapSearchAllVehiclesResponse(List<VehicleEntity> entities) {
		var vehiclesResponse = new SearchAllVehiclesResponseDTO();
		var vehicles = new ArrayList<VehicleResponseDTO>();
		entities.forEach(entity -> {
			var vehicle = mapVehicleResponse(entity);
			vehicles.add(vehicle);
		});
		vehiclesResponse.setVehicles(vehicles);
		return vehiclesResponse;
	}
	
	public static VehicleResponseDTO mapVehicleResponse(VehicleEntity entity) {
		var response = new VehicleResponseDTO();
		response.setId(entity.getId());
		response.setModel(entity.getModel());
		response.setBrand(entity.getBrand());
		response.setPlate(entity.getPlate());
		response.setYearFabrication(entity.getYearFabrication());
		return response;
	}
	
}
