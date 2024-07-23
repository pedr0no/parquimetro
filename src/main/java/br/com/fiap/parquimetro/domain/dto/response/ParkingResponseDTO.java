package br.com.fiap.parquimetro.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingResponseDTO {

	private String id;
	private String message;
	private String departureTime;
	private String description;
	private DriverResponseDTO driver;
	
}