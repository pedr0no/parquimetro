package br.com.fiap.parquimetro.application.service.mapper;

import java.time.temporal.ChronoUnit;

import br.com.fiap.parquimetro.domain.dto.request.ParkingRequestDTO;
import br.com.fiap.parquimetro.domain.dto.response.ParkingResponseDTO;
import br.com.fiap.parquimetro.domain.entity.DriverEntity;
import br.com.fiap.parquimetro.domain.entity.ParkingEntity;
import br.com.fiap.parquimetro.domain.entity.VehicleEntity;
import br.com.fiap.parquimetro.domain.enums.ParkingStatus;
import br.com.fiap.parquimetro.domain.enums.PaymentStatus;

public class ParkingMapper {

	public static ParkingEntity mapParkingEntity(ParkingRequestDTO request, DriverEntity driverEntity,
			VehicleEntity vehicleEntity) {
		var entity = new ParkingEntity();
		var departureTime = request.getEntryTime().plus(15, ChronoUnit.MINUTES);
		entity.setEntryTime(request.getEntryTime());
		entity.setDepartureTime(departureTime);
		entity.setPaymentStatus(PaymentStatus.PAID_OUT);
		entity.setParkingStatus(ParkingStatus.OCCUPY);
		entity.setInicialPayment(request.getInicialPayment());
		entity.setDriverCollection(driverEntity);
		entity.setVehicleCollection(vehicleEntity);
		return entity;
	}

	public static ParkingResponseDTO mapParkingResponse(ParkingEntity entity) {
		var response = new ParkingResponseDTO();
		response.setId(entity.getId());
		response.setMessage("Estacionamento registrado com sucesso");
		response.setDescription("Informo que o tempo limite é " + entity.getDepartureTime()
				+ ", se for ficar mais tempo, ao final do tempo faça o pagamento de " + entity.getInicialPayment());
		response.setDriver(DriverMapper.mapDriverResponseDTO(entity.getDriverCollection()));
		response.setVehicle(VehicleMapper.mapVehicleResponse(entity.getVehicleCollection()));
		return response;
	}

}
