package trainerHome.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trainerHome.service.ITrainerHomeService;
import trainerHome.service.TrainerHomeServiceImpl;
import trainerHome.vo.TrainerHomeVO;

@WebServlet("/trainerHome/list.do")
public class ListsellectAllTrainerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ITrainerHomeService trainerHomeService = TrainerHomeServiceImpl.getInstance();
		
		List<TrainerHomeVO> trainerList = trainerHomeService.getAllTrainerMainList();
		
		req.setAttribute("trainerList", trainerList);
		
		req.getRequestDispatcher("/views/trainerHome/allTrainerHome.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
