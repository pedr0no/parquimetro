package br.com.fiap.parquimetro.application.port.in;

import br.com.fiap.parquimetro.domain.dto.request.UpdateVehicleRequestDTO;
import br.com.fiap.parquimetro.domain.dto.response.SearchAllVehiclesResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.VehicleResponseDTO;

public interface VehiclePortIn {
	
	SearchAllVehiclesResponseDTO searchAllVehicles();
	
	VehicleResponseDTO searchVehicle(String idVehicle);
	
	VehicleResponseDTO updateVehicle(String idVehicle, UpdateVehicleRequestDTO body);
	
}
