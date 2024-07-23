package br.com.fiap.parquimetro.domain.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVehicleRequestDTO {

	private String model;
	private String brand;
	@Pattern(regexp = "^\\d{4}$", message = "O valor enviado para yearFabrication está inválido")
	private String yearFabrication;
	@Pattern(regexp = "^([A-Z]{3}-\\d{4}|[A-Z]{3}\\d[A-Z]\\d{2})$", message = "O valor enviado para plate está inválido")
	private String plate;

}
