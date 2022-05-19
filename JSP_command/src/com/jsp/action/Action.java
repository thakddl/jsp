package com.jsp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//톰켓의 execute는 접근자가 protected인데 여기서는 패키지 밖에서 상속관계와 상관없이 불러야 하기 때문에 퍼블릭이다.
	// 화면 url을 줘야하기 때문에 리턴타입이 스트링이다
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
