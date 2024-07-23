package br.com.fiap.parquimetro.domain.dto.request;

import java.util.List;

import br.com.fiap.parquimetro.domain.enums.FormPayment;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverRequestDTO {

	@NotBlank(message = "name é um campo obrigatório")
	private String name;
	private Integer age;
	@Pattern(regexp = "^(?!000|111|222|333|444|555|666|777|888|999)\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "O valor enviado para documentNumber está inválido")
	private String documentNumber;
	@NotNull(message = "formPayment é um campo obrigatório")
	private List<FormPayment> formPayment;
	@NotBlank(message = "email é um campo obrigatório")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "O valor enviado para email está inválido")
	private String email;
	@Pattern(regexp = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$", message = "O valor enviado para phoneNumber está inválido")
	@NotBlank(message = "phoneNumber é um campo obrigatório")
	private String phoneNumber;
	@NotNull(message = "vehicle é um campo obrigatório")
	@Valid
	private VehicleRequestDTO vehicle;

}
