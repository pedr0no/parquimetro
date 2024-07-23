package br.com.fiap.parquimetro.framework.adapter.out;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.fiap.parquimetro.application.port.out.DriverPortOut;
import br.com.fiap.parquimetro.domain.entity.DriverEntity;
import br.com.fiap.parquimetro.framework.adapter.in.exception.BusinessException;
import br.com.fiap.parquimetro.framework.adapter.out.db.DriverRepository;

import static java.util.Objects.nonNull;

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
		if (repository.findById(id).isPresent())
			return repository.findById(id).get();
		throw new BusinessException(HttpStatus.BAD_REQUEST, "driverId não foi encontrado no banco de dados");
	}

	@Override
	public DriverEntity updateDriver(DriverEntity entity, String id) {
		if (repository.findById(id).isEmpty())
			throw new BusinessException(HttpStatus.BAD_REQUEST, "driverId não foi encontrado no banco de dados");
		var outdatedEntity = repository.findById(id).get();
		this.builderUpdatedEntity(entity, outdatedEntity);
		return repository.save(outdatedEntity);
	}

	@Override
	public void deleteDriver(String id) {
		if (repository.findById(id).isEmpty())
			throw new BusinessException(HttpStatus.BAD_REQUEST, "driverId não foi encontrado no banco de dados");
		repository.deleteById(id);
	}

	private void builderUpdatedEntity(DriverEntity entity, DriverEntity outdatedEntity) {
		if (nonNull(entity.getAge()))
			outdatedEntity.setAge(entity.getAge());
		if (nonNull(entity.getDocumentNumber()))
			outdatedEntity.setDocumentNumber(entity.getDocumentNumber());
		if (nonNull(entity.getEmail()))
			outdatedEntity.setEmail(entity.getEmail());
		if (nonNull(entity.getFormPayment()))
			outdatedEntity.setFormPayment(entity.getFormPayment());
		if (nonNull(entity.getName()))
			outdatedEntity.setName(entity.getName());
		if (nonNull(entity.getPhoneNumber()))
			outdatedEntity.setPhoneNumber(entity.getPhoneNumber());
	}

}