package com.yckj.architecture1.common.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {
	
	public static String object2Str(Object obj){
		String retStr = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			retStr = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return retStr;
	}
	
	public static Object str2Object(String str,Class cls){
		Object retObj = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			retObj = mapper.readValue(str, cls);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retObj;
	}
}
