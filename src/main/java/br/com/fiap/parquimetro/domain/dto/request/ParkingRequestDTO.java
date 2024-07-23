package br.com.fiap.parquimetro.domain.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingRequestDTO {
	
	@NotNull
	private LocalDateTime entryTime;
	@Min(value = 3, message = "O valor tem que ser R$3,00")
	@Max(value = 3, message = "O valor tem que ser R$3,00")
	private BigDecimal inicialPayment;
	@NotBlank
	private String driverId;
	@NotBlank
	private String vehicleId;

}