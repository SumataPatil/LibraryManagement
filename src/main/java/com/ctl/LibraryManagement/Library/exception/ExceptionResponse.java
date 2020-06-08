package com.ctl.LibraryManagement.Library.exception;



import java.util.Date;
import java.util.Map;

import lombok.Data;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Data
public class ExceptionResponse   {

	  private String status;
	    private Map<String, String> message;
	    private String errorCode;

	    public String getErrorCode() {
	        return errorCode;
	    }

	    public void setErrorCode(String errorCode) {
	        this.errorCode = errorCode;
	    }

	    public ExceptionResponse() {
	        super();
	    }

	    public ExceptionResponse(String status, Map<String, String> message, String errorCode) {
	        //this.tiemstamp = tiemstamp;
	        this.status = status;
	        this.message = message;
	        this.errorCode=errorCode;
	    }

		/*public Date getTiemstamp() {
			return tiemstamp;
		}

		public void setTiemstamp(Date tiemstamp) {
			this.tiemstamp = tiemstamp;
		}*/

	    public Map<String, String> getMessage() {
	        return message;
	    }

	    public void setMessage(Map<String, String> message) {
	        this.message = message;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
	

	
	
	

}
