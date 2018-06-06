package com.jaken.lemoncatflow.exception;

public class FlowOperArgumentException extends RuntimeException{

	private String nextId;

	public FlowOperArgumentException(String nextId) {
		super();
		this.nextId = nextId;
	}
	
}
