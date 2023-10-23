package org.student.entity;

import org.springframework.http.HttpStatus;

import lombok.Data;
@Data
public class ResponseStructure<T> {
	private T body;
	private String message;
	 private HttpStatus code;
}
