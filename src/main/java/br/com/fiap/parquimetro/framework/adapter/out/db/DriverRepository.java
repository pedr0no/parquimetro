package br.com.fiap.parquimetro.framework.adapter.out.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.parquimetro.domain.entity.DriverEntity;

@Repository
public interface DriverRepository extends MongoRepository<DriverEntity, String> {

}