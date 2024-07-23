package br.com.fiap.parquimetro.framework.adapter.in.rest;

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
public class DriverController {

	@Autowired
	DriverPortIn driverPortIn;

	@PostMapping
	ResponseEntity<CreateDriverResponseDTO> createDriver(@RequestBody @Valid DriverRequestDTO body) {
		return ResponseEntity.status(HttpStatus.CREATED).body(driverPortIn.createDriver(body));
	}

	@GetMapping
	ResponseEntity<SearchAllDriversResponseDTO> searchAllDrivers() {
		return ResponseEntity.ok(driverPortIn.searchAllDrivers());
	}

	@GetMapping("/{idDriver}")
	ResponseEntity<DriverResponseDTO> searchDriver(@PathVariable String idDriver) {
		return ResponseEntity.ok(driverPortIn.searchDriver(idDriver));
	}

	@PatchMapping("/{idDriver}")
	ResponseEntity<DriverResponseDTO> updateDriver(@RequestBody UpdateDriverRequestDTO body,
			@PathVariable String idDriver) {
		return ResponseEntity.ok(driverPortIn.updateDriver(body, idDriver));
	}

	@DeleteMapping("/{idDriver}")
	ResponseEntity<Void> deleteDriver(@PathVariable String idDriver) {
		driverPortIn.deleteDriver(idDriver);
		return ResponseEntity.noContent().build();
	}

}