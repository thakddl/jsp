package com.jsp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dao.MemberDAO;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.dataresource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class MemberListServlet_억지 extends HttpServlet {
	
	private MemberService memberService; 
	
	@Override
	public void init() throws ServletException {//new로 생성하는 부분이 결합도가 너무 높아진다. 
		SqlSessionFactory sqlSessionFactory = new OracleMybatisSqlSessionFactory();
		
		MemberDAO memberDAO = new MemberDAOImpl();
		memberService = new MemberServiceImpl();
		
		if(memberService instanceof MemberServiceImpl) {
			MemberServiceImpl memberServiceImpl = (MemberServiceImpl)memberService;
			memberServiceImpl.setSqlSessionFactory(sqlSessionFactory);
			memberServiceImpl.setMemberDAO(memberDAO);
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/member/list.jsp";
		
		List<MemberVO> memberList = null;
		
		try {
			memberList = memberService.getMemberList();
		} catch (SQLException e) {
			url = "/WEB-INF/views/member/list_fail.jsp";
			e.printStackTrace();
		}
		request.setAttribute("memberList", memberList);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
