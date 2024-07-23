package br.com.fiap.parquimetro.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.parquimetro.application.port.in.VehiclePortIn;
import br.com.fiap.parquimetro.application.port.out.VehiclePortOut;
import br.com.fiap.parquimetro.application.service.mapper.VehicleMapper;
import br.com.fiap.parquimetro.domain.dto.request.UpdateVehicleRequestDTO;
import br.com.fiap.parquimetro.domain.dto.response.SearchAllVehiclesResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.VehicleResponseDTO;

@Service
public class VehicleService implements VehiclePortIn {

	@Autowired
	VehiclePortOut vehiclePortOut;

	@Override
	public SearchAllVehiclesResponseDTO searchAllVehicles() {
		return VehicleMapper.mapSearchAllVehiclesResponse(vehiclePortOut.searchAllVehicles());
	}

	@Override
	public VehicleResponseDTO searchVehicle(String idVehicle) {
		return VehicleMapper.mapVehicleResponse(vehiclePortOut.searchVehicle(idVehicle));
	}

	@Override
	public VehicleResponseDTO updateVehicle(String idVehicle, UpdateVehicleRequestDTO body) {
		var entity = VehicleMapper.mapVehicleEntity(body);
		return VehicleMapper.mapVehicleResponse(vehiclePortOut.updateVehicle(entity, idVehicle));
	}

}
