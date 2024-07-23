package br.com.fiap.parquimetro.application.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.parquimetro.domain.dto.request.ParkingRequestDTO;
import br.com.fiap.parquimetro.domain.dto.request.UpdateParkingRequestDTO;
import br.com.fiap.parquimetro.domain.dto.response.ParkingResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.SearchAllParkingResponseDTO;
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

	public static ParkingEntity mapParkingEntity(UpdateParkingRequestDTO request) {
		var entity = new ParkingEntity();
		var departureTime = request.getUpdatePaymentTime().plus(15, ChronoUnit.MINUTES);
		entity.setDepartureTime(departureTime);
		entity.setInicialPayment(request.getUpdatePayment());
		return entity;
	}

	public static ParkingResponseDTO mapParkingResponse(ParkingEntity entity) {
		var response = new ParkingResponseDTO();
		response.setId(entity.getId());
		response.setMessage("Estacionamento registrado com sucesso");
		response.setDepartureTime(formatDate(entity.getDepartureTime()));
		response.setDescription(
				"Se for ficar mais tempo, ao final do tempo faça o pagamento de " + entity.getInicialPayment());
		response.setDriver(DriverMapper.mapDriverResponseDTO(entity.getDriverCollection()));
		return response;
	}

	public static SearchAllParkingResponseDTO mapSearchAllParkingResponse(List<ParkingEntity> entities) {
		var response = new SearchAllParkingResponseDTO();
		var parkings = new ArrayList<ParkingResponseDTO>();
		entities.forEach(entity -> {
			var parking = mapParkingResponse(entity);
			parkings.add(parking);
		});
		response.setParkings(parkings);
		return response;
	}

	private static String formatDate(LocalDateTime date) {
		var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm:ss");
		return date.format(formatter);
	}
}
