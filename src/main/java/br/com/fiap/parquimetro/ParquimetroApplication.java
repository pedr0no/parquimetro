package br.com.fiap.parquimetro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.fiap.parquimetro.framework.adapter.out.db.DriverRepository;
import br.com.fiap.parquimetro.framework.adapter.out.db.ParkingRepository;
import br.com.fiap.parquimetro.framework.adapter.out.db.VehicleRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {
		DriverRepository.class,
		VehicleRepository.class,
		ParkingRepository.class
})
public class ParquimetroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParquimetroApplication.class, args);
	}

}
