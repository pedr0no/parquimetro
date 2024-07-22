package br.com.fiap.parquimetro.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.parquimetro.application.port.in.DriverPortIn;
import br.com.fiap.parquimetro.application.port.out.DriverPortOut;
import br.com.fiap.parquimetro.application.port.out.VehiclePortOut;
import br.com.fiap.parquimetro.application.service.mapper.DriverMapper;
import br.com.fiap.parquimetro.domain.dto.request.DriverRequestDTO;
import br.com.fiap.parquimetro.domain.dto.request.UpdateDriverRequestDTO;
import br.com.fiap.parquimetro.domain.dto.response.CreateDriverResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.DriverResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.SearchAllDriversResponseDTO;

@Service
public class DriverService implements DriverPortIn {

	@Autowired
	DriverPortOut driverPortOut;
	
	@Autowired
	VehiclePortOut vehiclePortOut;
	
	@Override
	@Transactional
	public CreateDriverResponseDTO createDriver(DriverRequestDTO request) {
		var entity = DriverMapper.mapDriverEntity(request);
		vehiclePortOut.createVehicle(entity.getVehicleCollection());
		var createDriver = driverPortOut.createDriver(entity);
		return DriverMapper.mapCreateDriverResponse(createDriver);
	}

	@Override
	public SearchAllDriversResponseDTO searchAllDrivers() {
		return DriverMapper.mapSearcAllDriversResponse(driverPortOut.searchAllDrivers());
	}

	@Override
	public DriverResponseDTO searchDriver(String idDriver) {
		return DriverMapper.mapDriverResponseDTO(driverPortOut.searchDriver(idDriver));
	}

	@Override
	public DriverResponseDTO updateDriver(UpdateDriverRequestDTO body, String id) {
		var entity = DriverMapper.mapUpdateDriverEntity(body);
		return DriverMapper.mapDriverResponseDTO(driverPortOut.updateDriver(entity, id));
	}

	@Override
	public void deleteDriver(String idDriver) {
		driverPortOut.deleteDriver(idDriver);
	}

}
