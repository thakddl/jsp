package com.jsp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StringMessageAction1 implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "message1";
		
		return message;
	}

}
