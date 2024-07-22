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
import br.com.fiap.parquimetro.domain.dto.request.VehicleRequestDTO;
import br.com.fiap.parquimetro.domain.dto.response.SearchAllVehiclesResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.VehicleResponseDTO;

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
	ResponseEntity<VehicleResponseDTO> updateVehicle(@RequestBody VehicleRequestDTO body,
			@PathVariable String idVehicle) {
		return ResponseEntity.ok(vehiclePortIn.updateVehicle(idVehicle, body));
	}

}
