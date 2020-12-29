package com.testyantra.tutorialsbatch.dto;

import org.springframework.stereotype.Component;

/**
 * This is Common Class for all Response Body which is having to check the error
 * and exceptions
 * 
 * @author Jalaj Kumar
 */
@Component
public class ResponceDto {

	/**
	 * to check the exception present or not returns true if error present or else
	 * false
	 */
	private boolean error;

	/** to store the Object which is set by Dto object */
	private Object data;

	/**Getters and Setters */
	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
