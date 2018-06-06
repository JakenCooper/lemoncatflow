package com.jaken.lemoncatflow.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaken.lemoncatflow.definition.Flow;
import com.jaken.lemoncatflow.definition.Node;
import com.jaken.lemoncatflow.definition.NodeSec;
import com.jaken.lemoncatflow.service.FlowDefinitionService;
import com.jaken.lemoncatflow.service.FlowService;
import com.jaken.lemoncatflow.temp.LemonCache;
import com.jaken.lemoncatflow.util.CommonUtils;

@Controller
public class MainController {

	@Autowired
	private FlowDefinitionService defService;
	
	@Autowired
	private FlowService flowService;
	
	@RequestMapping("/welcome")
	public String main(){
		return "main";
	}
	
	@RequestMapping("/menu")
	public String menu(){
		return "menu";
	}
	
	@RequestMapping("/flow")
	public String flow(){
		return "flowindex";
	}
	
	@RequestMapping("/node/view/add")
	public String nodeviewadd(HttpServletRequest request){
		request.setAttribute("flowid", request.getParameter("flowid"));
		return "nodeadd";
	}
	
	@RequestMapping("/flow/add")
	public ResponseEntity<Flow> flowadd(HttpServletRequest request){
		String name = request.getParameter("name");
		Flow flow = defService.createFlow(name);
		LemonCache.getFlows().add(flow);
		LemonCache.getFlowmap().put(flow.getId(), flow);
		return new ResponseEntity<Flow>(flow, HttpStatus.OK);
	}
	
	@RequestMapping("/node/add")
	public String nodeadd(HttpServletRequest request,Node node){
		Flow flow = LemonCache.getFlowmap().get(request.getParameter("flowid"));
		if(StringUtils.isBlank(node.getId())){
			node.setId(CommonUtils.genuuid());
		}
		defService.addNode(flow, node);
		request.setAttribute("closetag", "1");
		return "nodeadd";
	}
	
	@RequestMapping("flushlatest")
	public ResponseEntity<Flow> flushlatest(){
		if(LemonCache.getFlows().size() == 0){
			return new ResponseEntity<Flow>(new Flow("test"), HttpStatus.OK);
		}
		Flow flow = LemonCache.getFlows().get(0);
		return new ResponseEntity<Flow>(flow, HttpStatus.OK);
	}
	
	
	@RequestMapping("/nodesec/view/add")
	public String nodesecviewadd(HttpServletRequest request){
		Flow flow = LemonCache.getFlowmap().get(request.getParameter("flowid"));
		request.setAttribute("flowid", request.getParameter("flowid"));
		request.setAttribute("nodeid", request.getParameter("nodeid"));
		request.setAttribute("nodelst", flow.getNodes());
		return "nodesecadd";
	}
	
	@RequestMapping("/lemoncatflow/nodesec/add")
	public String nodesecadd(HttpServletRequest request){
		String nodeid = request.getParameter("nodeid");
		String flowid = request.getParameter("flowid");
		Flow flow = LemonCache.getFlowmap().get(request.getParameter("flowid"));
		List<NodeSec> nodeseclst =new ArrayList<NodeSec>();
		
		String[] nodeids = request.getParameterValues("nodesec");
		for(String secnodeid : nodeids){
			nodeseclst.add(new NodeSec(CommonUtils.genuuid(), nodeid, secnodeid));
		}
		
		Node targetnode = flow.getNodeById(nodeid);
		
		defService.addNodeSec(targetnode, nodeseclst);
		
		request.setAttribute("closetag", "1");
		return "nodesecadd";
	}
	
	
	
	
	
}
