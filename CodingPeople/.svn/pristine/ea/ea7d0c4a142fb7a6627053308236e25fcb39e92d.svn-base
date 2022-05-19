package adminCategory.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminCategory.service.AdminCategoryServiceImpl;
import adminCategory.service.IAdminCategoryService;
import adminCategory.vo.AdminCategoryVO;

/**
 * 관리자 > 전체 카테고리 조회 > 카테고리 수정 서블릿 카테고리 조회에서 카테고리 아이디 클릭 시 현 서블릿으로 이동
 * 
 * @author HJE
 */

@WebServlet("/admin/UpdateCategory.do")
public class UpdateCategoryController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서비스객체 생성
		IAdminCategoryService service = AdminCategoryServiceImpl.getInstance();

		// 파라미터 정보 가져오기
		String ctgrId = req.getParameter("ctgrId");

		// 카테고리 정보 조회
		AdminCategoryVO getCtgr = service.getCategory(ctgrId);

		req.setAttribute("ctgrListVo", getCtgr);
		
		// 업데이트 화면으로 포워딩
		req.getRequestDispatcher("/adminCategory/adminUpdateCategory.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서비스객체 생성
		IAdminCategoryService service = AdminCategoryServiceImpl.getInstance();
		AdminCategoryVO ctgrListVo = new AdminCategoryVO();
		
		String categoryId = req.getParameter("ctgrId");
		String categoryName = req.getParameter("ctgrName");
		
		ctgrListVo.setCategoryId(categoryId);
		ctgrListVo.setCategoryName(categoryName);
		
		int cnt = service.updateCategory(ctgrListVo);
		String msg = "";
		
		if(cnt>0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		req.setAttribute("updateMsg", msg);
		
		// 뷰화면 업데이트
		req.getRequestDispatcher("/admin/SelectAllCategories.do").forward(req, resp);
	}

}
