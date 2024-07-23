package br.com.fiap.parquimetro.framework.adapter.in.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.parquimetro.application.port.in.ParkingPortIn;
import br.com.fiap.parquimetro.domain.dto.request.ParkingRequestDTO;
import br.com.fiap.parquimetro.domain.dto.request.UpdateParkingRequestDTO;
import br.com.fiap.parquimetro.domain.dto.response.ParkingResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.SearchAllParkingResponseDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/parking")
public class ParkingController {

	@Autowired
	ParkingPortIn parkingPortIn;

	@PostMapping
	ResponseEntity<ParkingResponseDTO> occupyParking(@RequestBody @Valid ParkingRequestDTO body) {
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingPortIn.occupyParking(body));
	}

	@GetMapping
	ResponseEntity<SearchAllParkingResponseDTO> searchAllParkings() {
		return ResponseEntity.ok(parkingPortIn.searchAllParking());
	}

	@GetMapping("/{idParking}")
	ResponseEntity<ParkingResponseDTO> searchParking(@PathVariable String idParking) {
		return ResponseEntity.ok(parkingPortIn.searchParking(idParking));
	}

	@PatchMapping("/time/{idParking}")
	ResponseEntity<ParkingResponseDTO> updateParkingTime(@RequestBody @Valid UpdateParkingRequestDTO body,
			@PathVariable String idParking) {
		return ResponseEntity.ok(parkingPortIn.updateParkingTime(body, idParking));
	}

}