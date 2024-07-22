package br.com.fiap.parquimetro.application.port.in;

import br.com.fiap.parquimetro.domain.dto.request.DriverRequestDTO;
import br.com.fiap.parquimetro.domain.dto.request.UpdateDriverRequestDTO;
import br.com.fiap.parquimetro.domain.dto.response.CreateDriverResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.DriverResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.SearchAllDriversResponseDTO;

public interface DriverPortIn {

	CreateDriverResponseDTO createDriver(DriverRequestDTO request);
	
	SearchAllDriversResponseDTO searchAllDrivers();
	
	DriverResponseDTO searchDriver(String idDriver);
	
	DriverResponseDTO updateDriver(UpdateDriverRequestDTO body, String id);
	
	void deleteDriver(String idDriver);
	
}
