package login.service;

import coin.vo.MemberVO;
import login.dao.ILoginDao;
import login.dao.LoginDaoImpl;
import member.vo.JoinMemberVO;

public class LoginServiceImpl implements ILoginService {

	
	private static ILoginService loginService;
	
	
	//사용할 DAO의 객체변수를 선언한다.
	private ILoginDao serviceDao;
	
	private LoginServiceImpl() {
		serviceDao = LoginDaoImpl.getInstance();
	};
	
	public static ILoginService getInstance() {
		if(loginService == null) {
			loginService = new LoginServiceImpl();
		}
		return loginService;
	}
	
	@Override
	public int checkMember(String memId) {
		
		return serviceDao.checkMember(memId);
	}

	@Override
	public String getPass(String memId) {
		
		return serviceDao.getPass(memId);
	}

	@Override
	public String getMail(String memId) {
		return serviceDao.getMail(memId);
	}

	@Override
	public int updatePass(JoinMemberVO mv) {
		return serviceDao.updatePass(mv);
	}

	@Override
	public String getId(JoinMemberVO mv) {
		return serviceDao.getId(mv);
	}

	@Override
	public MemberVO getMember(String memId) {
		return serviceDao.getMember(memId);
	}

}
