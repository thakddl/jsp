package kr.or.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// super.onAuthenticationFailure(request, response, exception);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('일치안한대....다시햐ㅐ해ㅐ해해해햏해해해ㅐ')");
		out.println("history.go(-1)");
		out.println("</script>");
		
		
	}

	

}
