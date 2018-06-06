package com.jaken.lemoncatflow.util;

import java.util.UUID;

public class CommonUtils {

	public static String genuuid(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
