package br.com.fiap.parquimetro.domain.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateParkingRequestDTO {

	private LocalDateTime updatePaymentTime;
	@Min(value = 3, message = "O valor tem que ser R$3,00")
	@Max(value = 3, message = "O valor tem que ser R$3,00")
	private BigDecimal updatePayment;
	
}
