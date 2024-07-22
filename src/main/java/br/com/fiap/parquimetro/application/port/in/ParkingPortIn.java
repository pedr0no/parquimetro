package br.com.fiap.parquimetro.application.port.in;

import br.com.fiap.parquimetro.domain.dto.request.ParkingRequestDTO;
import br.com.fiap.parquimetro.domain.dto.response.ParkingResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.SearchAllParkingResponseDTO;

public interface ParkingPortIn {

	ParkingResponseDTO occupyParking(ParkingRequestDTO body);
	
	SearchAllParkingResponseDTO searchAllParking();
	
}
