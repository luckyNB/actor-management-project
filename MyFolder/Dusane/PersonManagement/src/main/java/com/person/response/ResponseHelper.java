package com.person.response;

public class ResponseHelper {

	public static Response statusInfo(int code,String message) {
		Response response=new Response();
		response.setResponseCode(code);
		response.setResponseStatus(message);
		return response;
	}
}
