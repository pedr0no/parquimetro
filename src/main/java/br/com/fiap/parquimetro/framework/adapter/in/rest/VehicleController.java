package br.com.fiap.parquimetro.framework.adapter.in.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.parquimetro.application.port.in.VehiclePortIn;
import br.com.fiap.parquimetro.domain.dto.request.UpdateVehicleRequestDTO;
import br.com.fiap.parquimetro.domain.dto.response.SearchAllVehiclesResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.VehicleResponseDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	VehiclePortIn vehiclePortIn;

	@GetMapping
	ResponseEntity<SearchAllVehiclesResponseDTO> searchAllVehicles() {
		return ResponseEntity.ok(vehiclePortIn.searchAllVehicles());
	}

	@GetMapping("/{idVehicle}")
	ResponseEntity<VehicleResponseDTO> searchVehicle(@PathVariable String idVehicle) {
		return ResponseEntity.ok(vehiclePortIn.searchVehicle(idVehicle));
	}

	@PatchMapping("/{idVehicle}")
	ResponseEntity<VehicleResponseDTO> updateVehicle(@RequestBody @Valid UpdateVehicleRequestDTO body,
			@PathVariable String idVehicle) {
		return ResponseEntity.ok(vehiclePortIn.updateVehicle(idVehicle, body));
	}

}
