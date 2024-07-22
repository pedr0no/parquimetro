package br.com.fiap.parquimetro.domain.dto.request;

import java.util.List;

import br.com.fiap.parquimetro.domain.enums.FormPayment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDriverRequestDTO {

	private String name;
	private Integer age;
	private String documentNumber;
	private List<FormPayment> formPayment;
	private String email;
	private Long phoneNumber;
	
}
