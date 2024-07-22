package br.com.fiap.parquimetro.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document("vehicleCollection")
@Getter
@Setter
public class VehicleEntity {

	@Id
	private String id;
	private String model;
	private String brand;
	private Integer yearFabrication;
	private String plate;
	
}
