package br.com.fiap.parquimetro.application.port.out;

import java.util.List;

import br.com.fiap.parquimetro.domain.entity.DriverEntity;

public interface DriverPortOut {

	DriverEntity createDriver(DriverEntity entity);
	
	List<DriverEntity> searchAllDrivers();
	
	DriverEntity searchDriver(String id);
	
	DriverEntity updateDriver(DriverEntity entity, String id);
	
	void deleteDriver(String id);
	
}
