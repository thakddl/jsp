package com.jsp.service;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.MemberVO;

public interface MemberService {
	
	public List<MemberVO> getMemberList() throws SQLException;

	public MemberVO getMemberDetail(String id) throws SQLException;

	public int deleteMember(String id) throws SQLException;

	public int updateMember(MemberVO member) throws SQLException;

	public int insertMember(MemberVO member) throws SQLException;

	public Boolean checkUserId(String id) throws SQLException;

	
}
