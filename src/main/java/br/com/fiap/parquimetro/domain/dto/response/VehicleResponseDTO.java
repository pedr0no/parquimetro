package br.com.fiap.parquimetro.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponseDTO {

	private String id;
	private String model;
	private String brand;
	private Integer yearFabrication;
	private String plate;

}
