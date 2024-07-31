package br.com.fiap.parquimetro.framework.adapter.out;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.fiap.parquimetro.application.port.out.ParkingPortOut;
import br.com.fiap.parquimetro.domain.entity.ParkingEntity;
import br.com.fiap.parquimetro.framework.adapter.in.exception.BusinessException;
import br.com.fiap.parquimetro.framework.adapter.out.db.ParkingRepository;

@Service
public class ParkingPortOutImpl implements ParkingPortOut {

	@Autowired
	ParkingRepository repository;

	@Override
	public ParkingEntity occupyParking(ParkingEntity entity) {
		return repository.save(entity);
	}

	@Override
	public ParkingEntity updateParking(ParkingEntity entity) { return repository.save(entity); }

	@Override
	public List<ParkingEntity> searchAllParking() {
		return repository.findAll();
	}

	@Override
	public ParkingEntity searchParking(String id) {
		if (repository.findById(id).isPresent())
			return repository.findById(id).get();
		throw new BusinessException(HttpStatus.BAD_REQUEST, "parkingId não foi encontrado no banco de dados");
	}

	@Override
	public ParkingEntity updateParkingTime(ParkingEntity entity, String id) {
		if (repository.findById(id).isEmpty())
			throw new BusinessException(HttpStatus.BAD_REQUEST, "parkingId não foi encontrado no banco de dados");
		var outdatedEntity = repository.findById(id).get();
		outdatedEntity.setInicialPayment(entity.getInicialPayment());
		outdatedEntity.setDepartureTime(entity.getDepartureTime());
		return repository.save(outdatedEntity);
	}

}