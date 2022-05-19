package clientMyPage.service;

import clientMyPage.dao.ClientMyPageDaoImpl;
import clientMyPage.dao.IClientMyPageDao;
import clientMyPage.vo.ClientMyPageVO;

public class ClientMyPageServiceImpl implements IClientMyPageService{

	// 멤버변수 선언
	private static IClientMyPageService mypageservice;
	private IClientMyPageDao mypageDao;
	
	public static IClientMyPageService getInstance() {
		if(mypageservice==null) {
			mypageservice=new ClientMyPageServiceImpl();
		}
		return mypageservice;
	}
	
	private ClientMyPageServiceImpl() {
		
		mypageDao = ClientMyPageDaoImpl.getInstance();
	}
	
	
	@Override
	public int updateMyPage(ClientMyPageVO mypageVo) {
		return mypageDao.updateMyPage(mypageVo);
	}

	@Override
	public int leaveMyPage(ClientMyPageVO mypageVo) {
		return mypageDao.leaveMyPage(mypageVo);
	}

	@Override
	public ClientMyPageVO getMyPage(String memId) {
		return mypageDao.getMyPage(memId);
	}

	
}
