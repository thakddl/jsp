package login.service;

import coin.vo.MemberVO;
import member.vo.JoinMemberVO;

public interface ILoginService {
	
	public int checkMember(String memId);
	
	public String getPass(String memId);
	
	public String getId(JoinMemberVO mv);
	
	public String getMail(String memId);
	
	public int updatePass(JoinMemberVO mv);
	
	public MemberVO getMember(String memId);
	 
}
