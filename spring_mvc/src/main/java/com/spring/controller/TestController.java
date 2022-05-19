package com.spring.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	// 키값 생성. url, goget, dopset 다 가져오는 역할
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	// @PostMapping(value = "/test"), @GetMapping(value = "/test")
	public String test() { // 어디로 갈지 view url
		
		String url="test/main";
		
		return url;
	}
	
	
	@RequestMapping(value = "/test/param", method = RequestMethod.GET)
	public String testParam(HttpServletRequest request, HttpServletResponse response) { 
		String url="test/main";
		
		String message = (String)request.getParameter("message");
		
		request.setAttribute("message", message);
		
		return url;
	}
	
	@RequestMapping(value = "/test2/param", method = RequestMethod.GET)
//	public String test2Param(String message,Model model) { 
//	public String test2Param(int message,Model model) { //bad request=400 
	public String test2Param(int messageTTT,Model model) { // 500에러(NULL)  
		String url="test/main";
		
//		String message = (String)request.getParameter("message");
		
		model.addAttribute("message", messageTTT);
		
		return url;
	}
	
	// case4) 화면 이름을 부여하지 않은 경우 -> 진짜 화면이 없으면 404
	@RequestMapping(value = "/test/main", method = RequestMethod.GET)
	public void test4Param(@ModelAttribute("message") String message) {
		
	}

	// case5) 넘어오는 파라미터 이름과 실제로 갖는 녀석의 이름이 다를경우 맵핑해주기 = @RequestParam
	@RequestMapping(value = "/test5/param", method = RequestMethod.GET)
	public String test5Param(@RequestParam(name="message", defaultValue="Have a nice Day!!!")
							 String msg, Model model) {
		//requestParam으로 오는 애의 이름을 msg라고 하겠다와 동일한 이야기
		// defaultValue=message라는 파라미터가 없으면 없으면 기본으로 주는애, null방지
		String url="test/main";
		
		model.addAttribute("message",msg);
		
		return url;
	}
	
	// case6) 파라미터 타입이 옳지 않음 = 400 
	//		     파라미터를 다 맞게 가져왔으나, 화면이 없음 = 404
	@RequestMapping(value = "/test6/param", method = RequestMethod.GET)
	public void test6Param(int a, String b, int c, Object d, boolean k) {
		System.out.println(a+":"+b+":"+c+":"+d+":"+k);
	}

	// case6-1)
	// 화면 결정인자(response) = 화면이 없어도 뭔가를 내보낼 수 있음
	// 화면은 보이는데 response로 뭔가를 보내려고 하나보다라고 adopter가 판단하고 오지랖을 안부림
	// url이 실제로 없다고 보고함
	@RequestMapping(value = "/test60/param", method = RequestMethod.GET)
	public void test6Param(CommandObject command, HttpServletResponse response) throws Exception {
		
		PrintWriter out = response.getWriter();
		out.println(command.a+":"+command.b+":"+command.c+":"+command.d+":"+command.k);
		
	}
}

class CommandObject{
	int a;
	String b;
	int c;
	Object d;
	boolean k;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public Object getD() {
		return d;
	}
	public void setD(Object d) {
		this.d = d;
	}
	public boolean isK() {
		return k;
	}
	public void setK(boolean k) {
		this.k = k;
	}
	
	
}





























