package br.com.fiap.parquimetro.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequestDTO {
	
	@NotBlank
	private String model;
	private String brand;
	private Integer yearFabrication;
	@NotBlank
	private String plate;

}