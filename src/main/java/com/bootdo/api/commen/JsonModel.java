package com.bootdo.api.commen;

import java.io.Serializable;

/**
 * json model
 * 
 * @author King64
 *
 */
@SuppressWarnings("serial")
public class JsonModel implements Serializable {

	private int status;
	private String message;
	private Object data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
