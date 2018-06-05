package com.jaken.lemoncatflow.definition;

import java.util.Map;
import java.util.Set;

public class Flow {
	private String id;
	
	private String name;
	
	private Set<Node> nodes;
	
	private Node startNode;
	
	private Map<String, Node> nodemap;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Node> getNodes() {
		return nodes;
	}


	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}


	public Node getStartNode() {
		return startNode;
	}


	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}


	public Map<String, Node> getNodemap() {
		return nodemap;
	}


	public void setNodemap(Map<String, Node> nodemap) {
		this.nodemap = nodemap;
	}


	public static void main(String[] args) {
		Node node1 = new Node("n1","n1");
		node1.setReadyToBegin(true);
		Node node2 = new Node("n2","n2");
		Node node3 = new Node("n3","n3");
		Node node4 = new Node("n4","n4");
		node4.setReadyToFinish(true);
		node1.addNodeSec(new NodeSec("n1_s1",node1.getId(),node2.getId()));
		node2.addNodeSec(new NodeSec("n2_s1",node2.getId(),node3.getId()));
		node2.addNodeSec(new NodeSec("n2_s2",node2.getId(),node4.getId()));
		node3.addNodeSec(new NodeSec("n3_s1",node3.getId(),node4.getId()));
	}
}
