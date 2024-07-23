package br.com.fiap.parquimetro.framework.adapter.out;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.fiap.parquimetro.application.port.out.VehiclePortOut;
import br.com.fiap.parquimetro.domain.entity.VehicleEntity;
import br.com.fiap.parquimetro.framework.adapter.in.exception.BusinessException;
import br.com.fiap.parquimetro.framework.adapter.out.db.VehicleRepository;

import static java.util.Objects.nonNull;

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
		if (repository.findById(id).isPresent())
			return repository.findById(id).get();
		throw new BusinessException(HttpStatus.BAD_REQUEST, "vehicleId não foi encontrado no banco de dados");
	}

	@Override
	public List<VehicleEntity> searchAllVehicles() {
		return repository.findAll();
	}

	@Override
	public VehicleEntity updateVehicle(VehicleEntity entity, String id) {
		if (repository.findById(id).isEmpty())
			throw new BusinessException(HttpStatus.BAD_REQUEST, "parkingId não foi encontrado no banco de dados");
		var outdatedEntity = repository.findById(id).get();
		this.builderUpdatedEntity(entity, outdatedEntity);
		return repository.save(outdatedEntity);
	}

	private void builderUpdatedEntity(VehicleEntity entity, VehicleEntity outdatedEntity) {
		if (nonNull(entity.getBrand()))
			outdatedEntity.setBrand(entity.getBrand());
		if (nonNull(entity.getModel()))
			outdatedEntity.setModel(entity.getModel());
		if (nonNull(entity.getPlate()))
			outdatedEntity.setPlate(entity.getPlate());
		if (nonNull(entity.getYearFabrication()))
			outdatedEntity.setYearFabrication(entity.getYearFabrication());
	}

}