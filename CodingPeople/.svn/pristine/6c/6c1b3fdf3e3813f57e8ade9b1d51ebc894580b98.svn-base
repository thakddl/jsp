package GroupStudy.Controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GroupStudy.Service.GroupStudyServiceImpl;
import GroupStudy.Service.IGroupStudyService;
import GroupStudy.VO.GroupStudyVO;
import coin.service.CoinServiceImpl;
import coin.service.IcoinService;
import coin.vo.MemberVO;
import member.service.IJoinMemberService;
import member.service.JoinMemberServiceImpl;
import member.vo.AllMembershipInfoVO;

@WebServlet("/groupStudy/Create.do")
public class CreateGroupStudy extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		System.out.println(memId);
		IcoinService memService = CoinServiceImpl.getInstance();
		MemberVO mv = memService.getMember(memId);
		
		if(Integer.parseInt(mv.getMgId()) == 0) {
			req.setAttribute("alert","abc");
			req.getRequestDispatcher("/studygroup.jsp").forward(req, resp);
		}
		req.getRequestDispatcher("/groupStudy/createGroupForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 요청 파라미커 정보 가져오기
		String sgroupTitle = req.getParameter("sgroupTitle");
		String sgroupTo = req.getParameter("sgroupTo");
		String sgroupPlace = req.getParameter("sgroupPlace");
		String sgroupLatitude = req.getParameter("sgroupLatitude");
		String sgroupLongitude = req.getParameter("sgroupLongitude");
		String sgroupSdate = req.getParameter("sgroupSdate");
		String sgroupEdate = req.getParameter("sgroupEdate");
		String sgroupContent = req.getParameter("sgroupContent");
		String memId = req.getParameter("memId");
		
		
		// 2. 서비스 객체 생성하기
		IGroupStudyService groupStudyService = GroupStudyServiceImpl.getInstance();
		
		// 3. 받아온 파라미터 정보 vo에 담기
		GroupStudyVO gsv = new GroupStudyVO();
		gsv.setSgroupTitle(sgroupTitle);
		gsv.setSgroupTo(sgroupTo);
		gsv.setSgroupPlace(sgroupPlace);
		gsv.setSgroupLatitude(sgroupLatitude);
		gsv.setSgroupLongitude(sgroupLongitude);
		gsv.setSgroupSdate(sgroupSdate);
		gsv.setSgroupEdate(sgroupEdate);
		gsv.setSgroupContent(sgroupContent);
		gsv.setMemId(memId);
		
		
		
		int cnt = groupStudyService.createGroupStudy(gsv);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		req.setAttribute("msg", msg);
		
		String redirectUrl = req.getContextPath() + "/groupStudy/list.do?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
	}
}
