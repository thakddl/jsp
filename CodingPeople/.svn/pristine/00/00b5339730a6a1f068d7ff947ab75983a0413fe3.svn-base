package GroupStudy.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GroupStudy.Service.GroupStudyServiceImpl;
import GroupStudy.Service.IGroupStudyService;
import GroupStudy.VO.GroupStudyVO;
import GroupStudy.VO.JoinVO;
import GroupStudy.VO.SMemberVO;

@WebServlet("/mygroupdetail.do")
public class MyGroupDetail extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


				// 1-1. 필요정보 가져오기
				String memId = req.getParameter("memId");
				
				// 1-2. 서비스 객체 얻기
				IGroupStudyService groupStudyService = GroupStudyServiceImpl.getInstance();
				
				// 2. 쿼리 실행하여 list에 담기
				List<SMemberVO> memList = groupStudyService.getMemberList(memId);
				GroupStudyVO gsDetail = groupStudyService.getGroupStudyDetailInfo(memId);
				
				List<JoinVO> groupStudyList = groupStudyService.myGroupStudyDetailInfo(memId);
				
				// 3. 리퀘스트 객체에 list 담기
				req.setAttribute("memList", memList);
				req.setAttribute("gsDetail", gsDetail);
				req.setAttribute("groupStudyList", groupStudyList);
				
				// 4. 디스패쳐에 리퀘스트 객체 담기
				RequestDispatcher dispatcher = req.getRequestDispatcher("/groupStudy/mygroupdetail.jsp");
				
				// 5. 디스패처 포워딩
				dispatcher.forward(req, resp);
		
	}
	
	
}
