package br.com.fiap.parquimetro.application.port.out;

import java.util.List;

import br.com.fiap.parquimetro.domain.entity.ParkingEntity;

public interface ParkingPortOut {

	ParkingEntity occupyParking(ParkingEntity entity);
	
	List<ParkingEntity> searchAllParking();
	
	ParkingEntity searchParking(String id);
	
	ParkingEntity updateParkingTime(ParkingEntity entity, String id);
}
