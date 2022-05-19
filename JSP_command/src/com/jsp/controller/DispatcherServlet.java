package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;

public class DispatcherServlet extends HttpServlet {
	private HandlerMapper handlerMapper;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String handlerProperty = config.getInitParameter("urlProperty");
		
		try {
			if (handlerProperty != null && !handlerProperty.isEmpty()) {
				handlerMapper = new HandlerMapper(handlerProperty);
			} else {
				handlerMapper = new HandlerMapper();
			}
			System.out.println("[DispatcherServlet] HandlerMapper가 준비되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[DispatcherServlet] HandlerMapper가 준비되지 않았습니다.");
		}
	}
		   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 URI 검출
		String command = request.getRequestURI();  // contextPath 포함.
		if (command.indexOf(request.getContextPath()) == 0) {  // contextPath 삭제
			command = command.substring(request.getContextPath().length());
		}	
	      
		// commandHandler 실행 (HandlerMapper 의뢰 handler 할당)
		Action action = null;
		String message = null;
		
		if (handlerMapper != null) {
			action = handlerMapper.getAction(command);
			if (action != null) { // 올바른 요청
				message = action.execute(request, response);
				System.out.println("message : " + message);
			} else {//servlet 매핑을 모두로 받기때문에 이 설정이 없으면 404안터진다.
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		} else {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

	}
}
	

