package com.jsp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
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

public class MemberDetailServlet extends HttpServlet {
	
	private MemberService memberService; 
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		try {
			String memberServiceStr = config.getInitParameter("memberService");
			String sqlSessionFactoryStr = config.getInitParameter("sqlSessionFactory"); 
			String memberDAOStr = config.getInitParameter("memberDAO");

			memberService = (MemberServiceImpl) Class.forName(memberServiceStr).newInstance();
			SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) Class.forName(sqlSessionFactoryStr).newInstance();
			MemberDAO memberDAO= (MemberDAOImpl) Class.forName(memberDAOStr).newInstance();
			
			if(memberService instanceof MemberServiceImpl) {
				MemberServiceImpl memberServiceImpl = (MemberServiceImpl) memberService;
				memberServiceImpl.setMemberDAO(memberDAO);
				memberServiceImpl.setSqlSessionFactory(sqlSessionFactory);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/member/detail.jsp";
		
		MemberVO member = null;
		String id = request.getParameter("id")==null? "":request.getParameter("id");
		try {
			member = memberService.getMemberDetail(id);
			System.out.println(member);
			request.setAttribute("member", member);
		} catch (SQLException e) {
			url = "/WEB-INF/views/member/detail_fail.jsp";
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
