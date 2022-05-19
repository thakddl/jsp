package login.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import Util.SqlMapClientFactory;
import coin.vo.MemberVO;
import member.vo.JoinMemberVO;

public class LoginDaoImpl implements ILoginDao{

	private SqlMapClient smc;
	private static ILoginDao loginDao;
	
	public LoginDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ILoginDao getInstance() {
		if(loginDao == null) {
			loginDao = new LoginDaoImpl();
		}
		return loginDao;
	}

	@Override
	public int checkMember(String memId) {
		int cnt = 0;
		try {
			 cnt = (int) smc.queryForObject("login.checkMember", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String getPass(String memId) {
		String pass = null;
		try {
			pass = (String) smc.queryForObject("login.getPass",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pass;
	}

	@Override
	public String getMail(String memId) {
		String mail = null;
		try {
			mail = (String) smc.queryForObject("login.getMail",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mail;
	}

	@Override
	public int updatePass(JoinMemberVO mv) {
		int cnt = 0;
		try {
			cnt = smc.update("login.updatePass",mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String getId(JoinMemberVO mv) {
		String id = null;
		try {
			id = (String) smc.queryForObject("login.getId",mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public MemberVO getMember(String memId) {
		
		MemberVO mv = new MemberVO();
		
		try {
			smc.queryForObject("member.getMember",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mv;
	}

}
