package br.com.fiap.parquimetro.framework.adapter.out;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.parquimetro.application.port.out.ParkingPortOut;
import br.com.fiap.parquimetro.domain.entity.ParkingEntity;
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
	public List<ParkingEntity> searchAllParking() {
		return repository.findAll();
	}
	
}