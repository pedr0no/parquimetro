package br.com.fiap.parquimetro.domain.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchAllParkingResponseDTO {
	
	private List<ParkingResponseDTO> parkings;

}
