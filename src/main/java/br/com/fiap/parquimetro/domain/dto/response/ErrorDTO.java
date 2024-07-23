package br.com.fiap.parquimetro.domain.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {

	private LocalDateTime timestamp;
	private String error;
	private String message;
	
}
