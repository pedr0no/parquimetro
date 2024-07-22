package br.com.fiap.parquimetro.domain.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.fiap.parquimetro.domain.enums.FormPayment;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "driverCollection")
@Getter
@Setter
public class DriverEntity {

	@Id
	private String id;
	private String name;
	private Integer age;
	private String documentNumber;
	private List<FormPayment> formPayment;
	private String email;
	private Long phoneNumber;
	@DBRef
	private VehicleEntity vehicleCollection;	
}
