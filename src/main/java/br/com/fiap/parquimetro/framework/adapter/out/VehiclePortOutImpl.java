package br.com.fiap.parquimetro.framework.adapter.out;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.parquimetro.application.port.out.VehiclePortOut;
import br.com.fiap.parquimetro.domain.entity.VehicleEntity;
import br.com.fiap.parquimetro.framework.adapter.out.db.VehicleRepository;

@Service
public class VehiclePortOutImpl implements VehiclePortOut {

	@Autowired
	VehicleRepository repository;

	@Override
	public VehicleEntity createVehicle(VehicleEntity entity) {
		return repository.save(entity);
	}

	@Override
	public VehicleEntity searchVehicle(String id) {
		return repository.findById(id).get();
	}

	@Override
	public List<VehicleEntity> searchAllVehicles() {
		return repository.findAll();
	}

	@Override
	public VehicleEntity updateVehicle(VehicleEntity entity, String id) {
		var outdatedEntity = repository.findById(id).get();
		outdatedEntity.setBrand(entity.getBrand());
		outdatedEntity.setModel(entity.getModel());
		outdatedEntity.setPlate(entity.getPlate());
		outdatedEntity.setYearFabrication(entity.getYearFabrication());
		return repository.save(outdatedEntity);
	}

}