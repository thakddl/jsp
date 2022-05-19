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
import GroupStudy.VO.SMemberVO;

@WebServlet("/smemberdelete.do")
public class SMemberDelete extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String sgroupId = req.getParameter("sgroupId");
		String memId = req.getParameter("memId");
		
		IGroupStudyService service = GroupStudyServiceImpl.getInstance();
		
		SMemberVO sv = new SMemberVO();
		sv.setSgroupId(sgroupId);
		sv.setMemId(memId);
		
		int cnt = service.smemberDelete(sv);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		req.setAttribute("msg", msg);
		
		String redirectUrl = req.getContextPath() + "/basket.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl);
		
		
	}
	
}
