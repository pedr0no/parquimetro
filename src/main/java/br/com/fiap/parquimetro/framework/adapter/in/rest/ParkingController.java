package br.com.fiap.parquimetro.framework.adapter.in.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.parquimetro.application.port.in.ParkingPortIn;

@RestController
@RequestMapping
public class ParkingController {
	
	@Autowired
	ParkingPortIn parkingPortIn;
	
}
