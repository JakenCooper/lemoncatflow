package com.jaken.lemoncatflow.instance;

import java.util.List;

import com.jaken.lemoncatflow.definition.Flow;
import com.jaken.lemoncatflow.definition.Node;

public class FlowInstance {

	private Flow flow ;
	
	private Integer currentStatus;
	

	private Task currentTask;
	
	private Node currentNode;
	
	private List<FlowRecord> flowRecords;

	public FlowInstance(Flow flow) {
		super();
		this.flow = flow;
	}

	public Flow getFlow() {
		return flow;
	}

	public void setFlow(Flow flow) {
		this.flow = flow;
	}

	public Integer getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(Integer currentStatus) {
		this.currentStatus = currentStatus;
	}

	public Task getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}

	public List<FlowRecord> getFlowRecords() {
		return flowRecords;
	}

	public void setFlowRecords(List<FlowRecord> flowRecords) {
		this.flowRecords = flowRecords;
	}
	
	
}
