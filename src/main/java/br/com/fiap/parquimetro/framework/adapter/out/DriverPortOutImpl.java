package br.com.fiap.parquimetro.framework.adapter.out;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.parquimetro.application.port.out.DriverPortOut;
import br.com.fiap.parquimetro.domain.entity.DriverEntity;
import br.com.fiap.parquimetro.framework.adapter.out.db.DriverRepository;

@Service
public class DriverPortOutImpl implements DriverPortOut {

	@Autowired
	DriverRepository repository;

	@Override
	public DriverEntity createDriver(DriverEntity entity) {
		return repository.save(entity);
	}

	@Override
	public List<DriverEntity> searchAllDrivers() {
		return repository.findAll();
	}

	@Override
	public DriverEntity searchDriver(String id) {
		return repository.findById(id).get();
	}

	@Override
	public DriverEntity updateDriver(DriverEntity entity, String id) {
		var outdatedEntity = repository.findById(id).get();
		outdatedEntity.setAge(entity.getAge());
		outdatedEntity.setDocumentNumber(entity.getDocumentNumber());
		outdatedEntity.setEmail(entity.getEmail());
		outdatedEntity.setFormPayment(entity.getFormPayment());
		outdatedEntity.setName(entity.getName());
		outdatedEntity.setPhoneNumber(entity.getPhoneNumber());
		return repository.save(outdatedEntity);
	}

	@Override
	public void deleteDriver(String id) {
		repository.deleteById(id);
	}

}