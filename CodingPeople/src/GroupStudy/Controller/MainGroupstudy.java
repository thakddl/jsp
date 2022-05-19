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
import GroupStudy.VO.JoinVO;

@WebServlet("/groupStudy/SimpleList.do")
public class MainGroupstudy extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 서비스 객체 얻기
		IGroupStudyService groupStudyService = GroupStudyServiceImpl.getInstance();
		
		// 2. 쿼리 실행하여 list에 담기
		List<JoinVO> gsList = groupStudyService.getGroupStudyInfo();
		
		// 3. 리퀘스트 객체에 list 담기
		req.setAttribute("gsList", gsList);
		
		// 4. 디스패쳐에 리퀘스트 객체 담기
		RequestDispatcher dispatcher = req.getRequestDispatcher("/groupStudy/viewGroupStudySimply.jsp");
		
		// 5. 디스패처 포워딩
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
