package br.com.fiap.parquimetro.framework.adapter.out.db;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Long, String> {

}
