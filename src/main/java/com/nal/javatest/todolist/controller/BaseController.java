package com.nal.javatest.todolist.controller;

import org.springframework.http.HttpStatus;

import com.nal.javatest.todolist.dto.ResponseAPI;

public abstract class BaseController {

	protected <T> ResponseAPI<T> success(T data) {
		return new ResponseAPI<>(HttpStatus.OK.value(), "OK", data);
	}

	protected <T> ResponseAPI<T> error(String message) {
		return new ResponseAPI<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}

}
