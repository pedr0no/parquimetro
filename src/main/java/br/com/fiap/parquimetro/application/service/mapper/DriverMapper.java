package br.com.fiap.parquimetro.application.service.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.parquimetro.domain.dto.request.DriverRequestDTO;
import br.com.fiap.parquimetro.domain.dto.request.UpdateDriverRequestDTO;
import br.com.fiap.parquimetro.domain.dto.response.CreateDriverResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.SearchAllDriversResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.DriverResponseDTO;
import br.com.fiap.parquimetro.domain.entity.DriverEntity;

public class DriverMapper {

	public static DriverEntity mapDriverEntity(DriverRequestDTO request) {
		var entity = new DriverEntity();
		entity.setName(request.getName());
		entity.setAge(request.getAge());
		entity.setDocumentNumber(request.getDocumentNumber());
		entity.setEmail(request.getEmail());
		entity.setFormPayment(request.getFormPayment());
		entity.setPhoneNumber(request.getPhoneNumber());
		entity.setVehicleCollection(VehicleMapper.mapVehicleEntity(request.getVehicle()));
		return entity;
	}

	public static DriverEntity mapUpdateDriverEntity(UpdateDriverRequestDTO request) {
		var entity = new DriverEntity();
		entity.setName(request.getName());
		entity.setAge(request.getAge());
		entity.setDocumentNumber(request.getDocumentNumber());
		entity.setEmail(request.getEmail());
		entity.setPhoneNumber(request.getPhoneNumber());
		entity.setFormPayment(request.getFormPayment());
		return entity;
	}

	public static CreateDriverResponseDTO mapCreateDriverResponse(DriverEntity entity) {
		var response = new CreateDriverResponseDTO();
		response.setIdDriver(entity.getId());
		response.setIdVehicle(entity.getVehicleCollection().getId());
		return response;
	}

	public static SearchAllDriversResponseDTO mapSearcAllDriversResponse(List<DriverEntity> entities) {
		var driversResponse = new SearchAllDriversResponseDTO();
		var drivers = new ArrayList<DriverResponseDTO>();
		entities.forEach(entity -> {
			var driver = mapDriverResponseDTO(entity);
			drivers.add(driver);
		});
		driversResponse.setDrivers(drivers);
		return driversResponse;
	}

	public static DriverResponseDTO mapDriverResponseDTO(DriverEntity entity) {
		var driver = new DriverResponseDTO();
		driver.setId(entity.getId());
		driver.setName(entity.getName());
		driver.setAge(entity.getAge());
		driver.setDocumentNumber(entity.getDocumentNumber());
		driver.setEmail(entity.getEmail());
		driver.setPhoneNumber(entity.getPhoneNumber());
		driver.setVehicle(VehicleMapper.mapVehicleResponse(entity.getVehicleCollection()));
		driver.setFormPayment(entity.getFormPayment());
		return driver;
	}

}
