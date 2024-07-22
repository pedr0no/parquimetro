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

@RestController
@RequestMapping("/parking")
public class ParkingController {

	@Autowired
	ParkingPortIn parkingPortIn;

	@PostMapping
	ResponseEntity<ParkingResponseDTO> occupyParking(@RequestBody ParkingRequestDTO body) {
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingPortIn.occupyParking(body));
	}

	@GetMapping
	ResponseEntity<SearchAllParkingResponseDTO> searchAllParkings() {
		return ResponseEntity.ok(parkingPortIn.searchAllParking());
	}

	@PatchMapping("/{idParking}")
	ResponseEntity<ParkingResponseDTO> updateParkingTime(@RequestBody UpdateParkingRequestDTO body,
			@PathVariable String idParking) {
		return null;
	}

}