package trainer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trainerChnl.vo.TrainerChnlVO;
import trainerList.service.ITrainerListService;
import trainerList.service.TrainerListServiceImpl;
import trainerList.vo.TrainerVO;

@WebServlet("/trainer/trainerList.do")
public class SellectAllTranierListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ITrainerListService trainerListService = TrainerListServiceImpl.getInstance();
		
		List<String> idlist = trainerListService.getAllTrainerId();
		
		List<TrainerVO> tList = new ArrayList<>();
		
		
		for(String i : idlist) {
		tList.add(trainerListService.gettrainerVO(i));
		}
		
		req.setAttribute("idlist", idlist);
		req.setAttribute("tList", tList);
		
		req.getRequestDispatcher("/views/trainer/trainerList.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
