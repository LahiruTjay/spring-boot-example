package com.retail.pos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.retail.pos.constant.CommonConstants;
import com.retail.pos.dto.response.GenericApiResponse;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = Exception.class)
	public GenericApiResponse handleBaseException(Exception e) {

		return new GenericApiResponse(CommonConstants.STATUS_FAILED, e.toString());
	}

}
