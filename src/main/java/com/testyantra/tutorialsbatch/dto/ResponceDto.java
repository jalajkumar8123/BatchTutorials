package com.testyantra.tutorialsbatch.dto;

import org.springframework.stereotype.Component;


@Component
public class ResponceDto {

	private boolean error;
	private Object data;
	private String messege;
	
	
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
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
