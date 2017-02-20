package com.declaration.api.components.entity;

import java.io.Serializable;
import java.util.List;

import com.declaration.api.components.enums.StatusResponse;

/**
 * Response model
 * 
 * @author olegnovatskiy
 *
 * @param <E>
 *            - type for return list of informations
 */
public class Response<E> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code;
	private StatusResponse status;
	private String message;
	private List<E> listResult;

	public Response(Integer code, StatusResponse status, String message, List<E> listResult) {
		this.code = code;
		this.status = status;
		this.message = message;
		this.listResult = listResult;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public StatusResponse getStatus() {
		return status;
	}

	public void setStatus(StatusResponse status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<E> getListResult() {
		return listResult;
	}

	public void setListResult(List<E> listResult) {
		this.listResult = listResult;
	}

}
