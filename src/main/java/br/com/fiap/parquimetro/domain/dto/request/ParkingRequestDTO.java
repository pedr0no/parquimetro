package br.com.fiap.parquimetro.domain.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingRequestDTO {
	
	private LocalDateTime entryTime;
	private BigDecimal inicialPayment;
	private String driverId;
	private String vehicleId;

}