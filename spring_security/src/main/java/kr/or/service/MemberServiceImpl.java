package kr.or.service;

import java.sql.SQLException;

import com.jsp.dto.MemberVO;

import kr.or.dao.MemberDAO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	
	@Override
	public MemberVO getMember(String id) throws SQLException {
		
		return null;
	}

}
