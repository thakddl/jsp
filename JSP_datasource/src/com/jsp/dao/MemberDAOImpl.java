package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public List<MemberVO> selectMemberList(SqlSession session) throws SQLException {
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList");
		return memberList;
	}

	@Override
	public MemberVO selectMemberDetail(SqlSession session, String id) throws SQLException {
		MemberVO member = session.selectOne("Member-Mapper.selectMemberDetail", id);
		return member;
	}

	@Override
	public int deleteMember(SqlSession session, String id) throws SQLException {
		int cnt = session.delete("Member-Mapper.deleteMember", id);
		return cnt;
	}

	@Override
	public int updateMember(SqlSession session, MemberVO member) throws SQLException {
		int cnt = session.update("Member-Mapper.updateMember", member);
		return cnt;
	}

	@Override
	public int insertMember(SqlSession session, MemberVO member) throws SQLException {
		int cnt = session.update("Member-Mapper.insertMember", member);
		return cnt;
	}

}
