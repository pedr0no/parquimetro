package br.com.fiap.parquimetro.domain.dto.request;

import java.util.List;

import br.com.fiap.parquimetro.domain.enums.FormPayment;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDriverRequestDTO {

	private String name;
	private Integer age;
	@Pattern(regexp = "^(?!000|111|222|333|444|555|666|777|888|999)\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "O valor enviado para documentNumber está inválido")
	private String documentNumber;
	private List<FormPayment> formPayment;
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "O valor enviado para email está inválido")
	private String email;
	@Pattern(regexp = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$", message = "O valor enviado para phoneNumber está inválido")
	private String phoneNumber;
	
}
