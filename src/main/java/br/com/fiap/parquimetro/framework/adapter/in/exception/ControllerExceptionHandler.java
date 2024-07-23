package br.com.fiap.parquimetro.framework.adapter.in.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.fiap.parquimetro.domain.dto.response.ErrorDTO;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		var stringBuilder = new StringBuilder();
		e.getFieldErrors().forEach(fieldError -> {
			stringBuilder.append(fieldError.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(ErrorDTO.builder().timestamp(LocalDateTime.now())
				.error(HttpStatus.BAD_REQUEST.name()).message(stringBuilder.toString()).build());
	}

	@ExceptionHandler(BusinessException.class)
	ResponseEntity<ErrorDTO> handleBusinessException(BusinessException e) {
		return ResponseEntity.status(e.getCode()).body(ErrorDTO.builder().error(e.getCode().name())
				.timestamp(LocalDateTime.now()).message(e.getMessage()).build());
	}

	@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorDTO> handleException(Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ErrorDTO.builder().timestamp(LocalDateTime.now()).error(HttpStatus.INTERNAL_SERVER_ERROR.name())
						.message(e.getMessage()).build());
	}
}