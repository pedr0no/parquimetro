package br.com.fiap.parquimetro.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.fiap.parquimetro.domain.enums.ParkingStatus;
import br.com.fiap.parquimetro.domain.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "parkingCollection")
@Getter
@Setter
public class ParkingEntity {

	@Id
	private String id;
	private LocalDateTime entryTime;
	private LocalDateTime departureTime;
	private PaymentStatus paymentStatus;
	private ParkingStatus parkingStatus;
	private BigDecimal inicialPayment;
	@DBRef
	private DriverEntity driverCollection;
	@DBRef
	private VehicleEntity vehicleCollection;
	
}