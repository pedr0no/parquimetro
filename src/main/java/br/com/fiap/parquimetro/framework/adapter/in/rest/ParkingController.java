package br.com.fiap.parquimetro.framework.adapter.in.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Parking", description = "Parking Controller")
public class ParkingController {

	@Autowired
	ParkingPortIn parkingPortIn;

	@Operation(summary = "Ocuppy a park")
	@ApiResponse(responseCode = "201", description = "Ocuppy a park", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ParkingResponseDTO.class))})
	@PostMapping
	ResponseEntity<ParkingResponseDTO> occupyParking(@RequestBody @Valid ParkingRequestDTO body) {
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingPortIn.occupyParking(body));
	}

	@Operation(summary = "Search all the parks")
	@ApiResponse(responseCode = "200", description = "Search all the parks", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = SearchAllParkingResponseDTO.class))})
	@GetMapping
	ResponseEntity<SearchAllParkingResponseDTO> searchAllParkings() {
		return ResponseEntity.ok(parkingPortIn.searchAllParking());
	}

	@Operation(summary = "Search a specified park")
	@ApiResponse(responseCode = "200", description = "Search a specified park", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ParkingResponseDTO.class))})
	@GetMapping("/{idParking}")
	ResponseEntity<ParkingResponseDTO> searchParking(@PathVariable String idParking) {
		return ResponseEntity.ok(parkingPortIn.searchParking(idParking));
	}

	@Operation(summary = "Update parking time")
	@ApiResponse(responseCode = "200", description = "Update parking time", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ParkingResponseDTO.class))})
	@PatchMapping("/time/{idParking}")
	ResponseEntity<ParkingResponseDTO> updateParkingTime(@RequestBody @Valid UpdateParkingRequestDTO body,
			@PathVariable String idParking) {
		return ResponseEntity.ok(parkingPortIn.updateParkingTime(body, idParking));
	}

}