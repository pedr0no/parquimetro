package br.com.fiap.parquimetro.framework.adapter.in.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Vehicle", description = "Vehicle Controller")
public class VehicleController {

	@Autowired
	VehiclePortIn vehiclePortIn;

	@Operation(summary = "Get all the vehicles")
	@ApiResponse(responseCode = "200", description = "Get all the vehicles", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = SearchAllVehiclesResponseDTO.class))})
	@GetMapping
	ResponseEntity<SearchAllVehiclesResponseDTO> searchAllVehicles() {
		return ResponseEntity.ok(vehiclePortIn.searchAllVehicles());
	}

	@Operation(summary = "Get a specified vehicle")
	@ApiResponse(responseCode = "200", description = "Get a specified vehicle", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = VehicleResponseDTO.class))})
	@GetMapping("/{idVehicle}")
	ResponseEntity<VehicleResponseDTO> searchVehicle(@PathVariable String idVehicle) {
		return ResponseEntity.ok(vehiclePortIn.searchVehicle(idVehicle));
	}

	@Operation(summary = "Update a vehicle")
	@ApiResponse(responseCode = "200", description = "Update a vehicle", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = VehicleResponseDTO.class))})
	@PatchMapping("/{idVehicle}")
	ResponseEntity<VehicleResponseDTO> updateVehicle(@RequestBody @Valid UpdateVehicleRequestDTO body,
			@PathVariable String idVehicle) {
		return ResponseEntity.ok(vehiclePortIn.updateVehicle(idVehicle, body));
	}

}
