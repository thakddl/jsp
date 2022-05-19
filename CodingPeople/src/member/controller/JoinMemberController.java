package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IJoinMemberService;
import member.service.JoinMemberServiceImpl;
import member.vo.JoinMemberVO;

/**
 * Servlet implementation class JoinMemberController
 * 회원가입 servlet
 */
@WebServlet("/member/joinMember.do")
public class JoinMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/membership.jsp").forward(req, resp);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 폼 양식에 입력된 데이터 받아서 회원가입 진행
		// 1. 요청 파라미터 정보 가져옴
		String memId 	= req.getParameter("id");
		String inputPass= req.getParameter("password"); // 사용자로부터 입력받은 pw
		String hashPass	= SHA256.encodeSha256(inputPass); // 사용자로부터 입력받은 inputPass 암호화 
		String memName	= req.getParameter("name");
		String memBir	= req.getParameter("bir");
		String memAdd1	= req.getParameter("add1");
		String memAdd2	= req.getParameter("add2");
		String memZip	= req.getParameter("memZip");
		String memTel	= req.getParameter("tel");
		String memMail	= req.getParameter("mail"); 
		
		// 2. 서비스 객체 가져옴
		IJoinMemberService joinMemberService = JoinMemberServiceImpl.getInstance();

		// 3. 회원정보 등록
		JoinMemberVO vo = new JoinMemberVO();
		vo.setMemId(memId);
		vo.setMemPass(hashPass);
		vo.setMemName(memName);
//		vo.setMemBir(memBir.replace("-", ""));
		vo.setMemBir(memBir);
		vo.setMemAdd1(memAdd1);
		vo.setMemAdd2(memAdd2);
		vo.setMemZip(memZip);
		vo.setMemTel(memTel);
		vo.setMemMail(memMail);
		
		int cnt = joinMemberService.joinMember(vo);
		
		req.setAttribute("cnt", cnt);
		req.getRequestDispatcher("/membership_join.jsp").forward(req, resp);		
	}

}