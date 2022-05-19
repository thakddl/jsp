package member.dao;

import adminMember.vo.AllMembershipInfoVO;
import member.vo.JoinMemberVO;

public interface  IJoinMemberDAO {
	
	// 회원가입 메서드
	public int joinMember(JoinMemberVO vo);
	
	// 아이디 중복체크 메서드
	public boolean idCheck(String id);
	
	// 회원 세부정보 가져오는 메서드
	public AllMembershipInfoVO getMember(String memId);
	
	// 회원탈퇴 메서드
	public int secessionMember(String memId);
}
