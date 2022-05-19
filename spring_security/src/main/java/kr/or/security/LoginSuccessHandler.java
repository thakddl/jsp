package kr.or.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.jsp.dto.MemberVO;

import kr.or.service.MemberService;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		UserDetails user = (UserDetails)authentication.getPrincipal();
		String username = user.getUsername();
		
		try {
			MemberVO loginUser = memberService.getMember(username);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		super.onAuthenticationSuccess(request, response, authentication);
		
	}

}
