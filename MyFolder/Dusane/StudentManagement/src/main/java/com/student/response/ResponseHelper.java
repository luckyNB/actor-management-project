package com.student.response;

public class ResponseHelper {

	public static Response statusInfo(int code,String message) {
		Response response=new Response();
		response.setStatusCode(code);
		response.setStatusMessage(message);
		return response;
				
	}
}
