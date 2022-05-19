package com.jsp.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dao.MemberDAO;
import com.jsp.dto.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	
	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<MemberVO> memberList = memberDAO.selectMemberList(session);
			return memberList;
		} finally {
			session.close();
		}
		
	}


	@Override
	public MemberVO getMemberDetail(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			MemberVO member = memberDAO.selectMemberDetail(session, id);
			return member;
		} finally {
			session.close();
		}
	}


	@Override
	public int deleteMember(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {			
			int cnt = memberDAO.deleteMember(session, id);
			return cnt;
		} finally {
			session.close();
		}
		
	}


	@Override
	public int updateMember(MemberVO member) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int cnt = memberDAO.updateMember(session, member);
			return cnt;			
		} finally {
			session.close();
		}
	}


	@Override
	public int insertMember(MemberVO member) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int cnt = memberDAO.insertMember(session, member);
			return cnt;			
		} finally {
			session.close();
		}
	}


	@Override
	public Boolean checkUserId(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		Boolean exist = true; 
		try {
			MemberVO member = memberDAO.selectMemberDetail(session, id);
			if(member==null) {
				exist = false;
			}
		} finally {
			session.close();
		}
		return exist;			
	}


}
