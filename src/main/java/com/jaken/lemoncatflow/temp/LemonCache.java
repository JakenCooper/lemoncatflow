package com.jaken.lemoncatflow.temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jaken.lemoncatflow.definition.Flow;

public class LemonCache {

	private static List<Flow> flows = new ArrayList<Flow>();
	
	private static Map<String, Flow> flowmap = new HashMap<String, Flow>(); 

	public static List<Flow> getFlows() {
		return flows;
	}

	public static Map<String, Flow> getFlowmap() {
		return flowmap;
	}
	
}
