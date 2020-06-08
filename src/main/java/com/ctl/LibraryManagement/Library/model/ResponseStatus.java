package com.ctl.LibraryManagement.Library.model;

import lombok.Data;

@Data
public class ResponseStatus {
	
	private String status;
	
	

	public ResponseStatus() {
		super();
	}

	public ResponseStatus(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
