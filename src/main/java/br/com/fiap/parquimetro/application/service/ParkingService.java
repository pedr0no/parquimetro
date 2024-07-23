package br.com.fiap.parquimetro.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.parquimetro.application.port.in.ParkingPortIn;
import br.com.fiap.parquimetro.application.port.out.DriverPortOut;
import br.com.fiap.parquimetro.application.port.out.ParkingPortOut;
import br.com.fiap.parquimetro.application.port.out.VehiclePortOut;
import br.com.fiap.parquimetro.application.service.mapper.ParkingMapper;
import br.com.fiap.parquimetro.domain.dto.request.ParkingRequestDTO;
import br.com.fiap.parquimetro.domain.dto.request.UpdateParkingRequestDTO;
import br.com.fiap.parquimetro.domain.dto.response.ParkingResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.SearchAllParkingResponseDTO;
import br.com.fiap.parquimetro.domain.entity.ParkingEntity;

@Service
public class ParkingService implements ParkingPortIn {

	@Autowired
	ParkingPortOut parkingPortOut;

	@Autowired
	DriverPortOut driverPortOut;

	@Autowired
	VehiclePortOut vehiclePortOut;

	@Override
	@Transactional
	public ParkingResponseDTO occupyParking(ParkingRequestDTO body) {
		var driverEntity = driverPortOut.searchDriver(body.getDriverId());
		var vehicleEntity = vehiclePortOut.searchVehicle(body.getVehicleId());
		var entity = ParkingMapper.mapParkingEntity(body, driverEntity, vehicleEntity);
		ParkingEntity parkingEntity = parkingPortOut.occupyParking(entity);
		return ParkingMapper.mapParkingResponse(parkingEntity);
	}

	@Override
	public SearchAllParkingResponseDTO searchAllParking() {
		return ParkingMapper.mapSearchAllParkingResponse(parkingPortOut.searchAllParking());
	}

	@Override
	public ParkingResponseDTO searchParking(String idParking) {
		return ParkingMapper.mapParkingResponse(parkingPortOut.searchParking(idParking));
	}

	@Override
	public ParkingResponseDTO updateParkingTime(UpdateParkingRequestDTO body, String idParking) {
		var entity = parkingPortOut.updateParkingTime(ParkingMapper.mapParkingEntity(body), idParking);
		return ParkingMapper.mapParkingResponse(entity);
	}

}