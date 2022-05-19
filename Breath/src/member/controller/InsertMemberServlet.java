package member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

@WebServlet("/insert.Member")
public class InsertMemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/signin/signup.html").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		// 1. 요청 파라미터 정보 가져오기
		MemberVO mv = new MemberVO();
		// BeanUtils : Map을 Bean 객체로 바꿔주는 클래스
		// 			>> java Bean(vo) 객체에 맞추어 값을 자동으로 넣어준다.
		try {
			BeanUtils.populate(mv, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. 서비스 객체 생성하기
		IMemberService memberService = MemberServiceImpl.getInstance();
		
		// 3. 회원정보 등록
		
		int cnt = memberService.insertMember(mv);
		
		if (cnt > 0) {
			req.setAttribute("uId", mv.getMemId());
		} else {
			req.setAttribute("uId", null);
		}

		// jsp로 포워딩
		req.getRequestDispatcher("/views/signin/join.jsp").forward(req, resp);

	}
}
