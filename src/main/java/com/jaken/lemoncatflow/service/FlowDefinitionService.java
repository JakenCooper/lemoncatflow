package com.jaken.lemoncatflow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jaken.lemoncatflow.definition.Flow;
import com.jaken.lemoncatflow.definition.Node;
import com.jaken.lemoncatflow.definition.NodeSec;
import com.jaken.lemoncatflow.exception.FlowIllegalArgumentException;
import com.jaken.lemoncatflow.util.CommonUtils;

@Service
public class FlowDefinitionService {

	public Flow createFlow(String name){
		Flow flow = new Flow(CommonUtils.genuuid());
		flow.setName(name);
		return flow;
	}
	
	public void addNode(Flow flow,Node node){
		flow.getNodes().add(node);
		if(node.isReadyToBegin()){
			if(flow.getStartNode() != null){
				throw new FlowIllegalArgumentException("already has start node");
			}
			flow.setStartNode(node);
		}
		flow.getNodemap().put(node.getId(), node);
	}

	public void addNodeSec(Node node,NodeSec sec){
		node.getSecs().add(sec);
	}
	
	public void addNodeSec(Node node,List<NodeSec> secs){
		node.getSecs().addAll(secs);
	}
}
