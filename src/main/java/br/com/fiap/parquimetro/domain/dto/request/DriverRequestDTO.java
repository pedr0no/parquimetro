package br.com.fiap.parquimetro.domain.dto.request;

import java.util.List;

import br.com.fiap.parquimetro.domain.enums.FormPayment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverRequestDTO {

	@NotBlank
	private String name;
	private Integer age;
	private String documentNumber;
	@NotNull
	private List<FormPayment> formPayment;
	@NotBlank
	private String email;
	@NotNull
	private Long phoneNumber;
	@NotNull
	private VehicleRequestDTO vehicle;

}
