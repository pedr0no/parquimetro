package br.com.fiap.parquimetro.framework.adapter.in.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.parquimetro.application.port.in.DriverPortIn;
import br.com.fiap.parquimetro.domain.dto.request.DriverRequestDTO;
import br.com.fiap.parquimetro.domain.dto.request.UpdateDriverRequestDTO;
import br.com.fiap.parquimetro.domain.dto.response.CreateDriverResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.DriverResponseDTO;
import br.com.fiap.parquimetro.domain.dto.response.SearchAllDriversResponseDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/driver")
@Tag(name = "Driver", description = "Driver Controller")
public class DriverController {

	@Autowired
	DriverPortIn driverPortIn;

	@Operation(summary = "Create driver and vehicle")
	@ApiResponse(responseCode = "201", description = "Create driver and vehicle", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = CreateDriverResponseDTO.class))})
	@PostMapping
	ResponseEntity<CreateDriverResponseDTO> createDriver(@RequestBody @Valid DriverRequestDTO body) {
		return ResponseEntity.status(HttpStatus.CREATED).body(driverPortIn.createDriver(body));
	}

	@Operation(summary = "Get all the drivers")
	@ApiResponse(responseCode = "200", description = "Get all the drivers", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = SearchAllDriversResponseDTO.class))})
	@GetMapping
	ResponseEntity<SearchAllDriversResponseDTO> searchAllDrivers() {
		return ResponseEntity.ok(driverPortIn.searchAllDrivers());
	}

	@Operation(summary = "Get a driver by id")
	@ApiResponse(responseCode = "200", description = "Create driver and vehicle", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = DriverResponseDTO.class))})
	@GetMapping("/{idDriver}")
	ResponseEntity<DriverResponseDTO> searchDriver(@PathVariable String idDriver) {
		return ResponseEntity.ok(driverPortIn.searchDriver(idDriver));
	}

	@Operation(summary = "Update a driver information by id")
	@ApiResponse(responseCode = "200", description = "Create driver and vehicle", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = DriverResponseDTO.class))})
	@PatchMapping("/{idDriver}")
	ResponseEntity<DriverResponseDTO> updateDriver(@RequestBody UpdateDriverRequestDTO body,
			@PathVariable String idDriver) {
		return ResponseEntity.ok(driverPortIn.updateDriver(body, idDriver));
	}

	@Operation(summary = "Delete a driver by id")
	@ApiResponse(responseCode = "200", description = "Delete a driver by id", content = {
			@Content(mediaType = "application/json")})
	@DeleteMapping("/{idDriver}")
	ResponseEntity<Void> deleteDriver(@PathVariable String idDriver) {
		driverPortIn.deleteDriver(idDriver);
		return ResponseEntity.ok().build();
	}

}