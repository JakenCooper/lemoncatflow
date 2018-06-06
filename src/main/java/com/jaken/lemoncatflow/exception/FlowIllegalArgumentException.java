package com.jaken.lemoncatflow.exception;

public class FlowIllegalArgumentException extends RuntimeException{

	private String msg;

	public FlowIllegalArgumentException(String msg) {
		super();
		this.msg = msg;
	}
	
}
