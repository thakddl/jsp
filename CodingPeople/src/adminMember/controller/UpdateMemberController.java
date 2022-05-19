package adminMember.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.SHA256;
import adminMember.service.AdminMemServiceImpl;
import adminMember.service.IAdminMemService;
import adminMember.vo.AllMembershipInfoVO;

/**
 * 관리자 > 회원조회 > 정보수정 서블릿
 * 		   회원조회에서 회원 아이디 클릭 시 현 서블릿으로 이동 
 * @author HJE
 *
 */

@WebServlet("/admin/UpdateMember.do")
public class UpdateMemberController extends HttpServlet{
	
	@Override
	// 선택한 회원의 회원정보 보여줌
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 정보 가져오기
		String memId = req.getParameter("memId");
		
		// 서비스 객체 가져오기
		IAdminMemService adminMemService = AdminMemServiceImpl.getInstance();
		
		// 회원정보 조회
		AllMembershipInfoVO getMember = adminMemService.getMember(memId);
		
		req.setAttribute("memListVo", getMember);
		
		// 업데이트 화면으로 포워딩
		req.getRequestDispatcher("/adminClient/adminUpdateMember.jsp").forward(req, resp);
	}
	
	
	@Override
	// 선택한 회원 정보 업데이트함
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String inpuPass	= req.getParameter("memPass");
//		String hashPass = SHA256.encodeSha256(inpuPass);
		String memId	= req.getParameter("memId");
		String memName	= req.getParameter("memName");
		String memBir	= req.getParameter("memBir");
		String memAdd1	= req.getParameter("memAdd1");
		String memAdd2	= req.getParameter("memAdd2");
		String memZip	= req.getParameter("memZip");
		String memTel	= req.getParameter("memTel");
		String memMail	= req.getParameter("memMail");
//		String mgId		= req.getParameter("mgId");
//		String memCoin	= req.getParameter("memCoin");
//		String memPoint	= req.getParameter("memPoint");
		String msId		= req.getParameter("msId");
		
		IAdminMemService adminMemService = AdminMemServiceImpl.getInstance();
		
		AllMembershipInfoVO memListVo = new AllMembershipInfoVO();
		
//		memListVo.setMemPass(hashPass);     //비밀번호
		memListVo.setMemId(memId);          //아이디
		memListVo.setMemName(memName);      //이름
		memListVo.setMemBir(memBir);        //생일
		memListVo.setMemAdd1(memAdd1);      //주소
		memListVo.setMemAdd2(memAdd2);      //상세주소 
		memListVo.setMemZip(memZip);        //우편번호 
		memListVo.setMemTel(memTel);        //전화번호
		memListVo.setMemMail(memMail);      //이메일
//		memListVo.setMgId(mgId);            //회원등급 
//		memListVo.setMemCoin(memCoin);      //코딩코인 
//		memListVo.setMemPoint(memPoint);    //활동포인트 
		memListVo.setMsId(msId);            //회원상태 
		
		int cnt = adminMemService.updateMember(memListVo);
		String msg = "";
		
		if(cnt>0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		req.setAttribute("updateMsg", msg);
		
		// 뷰 화면 업데이트
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/selectAll.do");
		dispatcher.forward(req, resp);
		
//		String redirectUrl = req.getContextPath()+"/admin/selectAll.do?meg="+URLEncoder.encode(msg,"UTF-8");
//		resp.sendRedirect(redirectUrl);
	}
}

