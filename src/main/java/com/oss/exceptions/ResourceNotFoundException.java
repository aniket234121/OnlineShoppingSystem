package com.oss.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String serviceName;
	private String fieldName;
	private Integer fieldValue;
	public ResourceNotFoundException(String serviceName, String fieldName, Integer fieldValue) {
		super(String.format("%s not found with %s in %s",fieldName,fieldValue,serviceName));
		this.serviceName = serviceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	

}
