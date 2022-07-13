package com.hussain.crud.Exception;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
	
	private Date timestamp;
	private String message;
	private List<String> details;

}
