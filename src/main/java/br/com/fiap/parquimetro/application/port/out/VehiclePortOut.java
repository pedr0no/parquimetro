package br.com.fiap.parquimetro.application.port.out;

import java.util.List;

import br.com.fiap.parquimetro.domain.entity.VehicleEntity;

public interface VehiclePortOut {

	VehicleEntity createVehicle(VehicleEntity entity);

	List<VehicleEntity> searchAllVehicles();
	
	VehicleEntity searchVehicle(String id);
	
	VehicleEntity updateVehicle(VehicleEntity entity, String id);
}
