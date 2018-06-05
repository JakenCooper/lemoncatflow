package com.jaken.lemoncatflow.instance;

public class Task {

	private String nodeId;
	
	private String assignee;
	
	private Object bussObj;

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public Object getBussObj() {
		return bussObj;
	}

	public void setBussObj(Object bussObj) {
		this.bussObj = bussObj;
	}
}
