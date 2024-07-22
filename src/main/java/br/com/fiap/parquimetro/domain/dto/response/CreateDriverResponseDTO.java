package br.com.fiap.parquimetro.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDriverResponseDTO {
	
	private String idDriver;
	private String idVehicle;

}