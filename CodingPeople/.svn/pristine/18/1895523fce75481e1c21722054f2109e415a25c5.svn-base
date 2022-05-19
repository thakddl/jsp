package clientMyPage.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import Util.SqlMapClientFactory;
import clientMyPage.vo.ClientMyPageVO;

public class ClientMyPageDaoImpl implements IClientMyPageDao {

	// 싱글톤으로 만들기 위한 멤버변수 선언
	private static IClientMyPageDao myPageDao;
	
	private SqlMapClient smc;
	
	// 생성자 private
	private ClientMyPageDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	// static메소드 만들기
	public static IClientMyPageDao getInstance() {
		if(myPageDao==null) {
			myPageDao=new ClientMyPageDaoImpl();
		}
		return myPageDao;
	}
	
	
	@Override
	public int updateMyPage(ClientMyPageVO mypageVo) {
		int cnt = 0;
		
		try {
			cnt = smc.update("clientMyPage.updateMyPage",mypageVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int leaveMyPage(ClientMyPageVO mypageVo) {
		int cnt = 0;
		
		try {
			cnt = smc.update("clientMyPage.leaveMyPage",mypageVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public ClientMyPageVO getMyPage(String memId) {
		ClientMyPageVO mypageVO = new ClientMyPageVO();
		
		try {
			mypageVO = (ClientMyPageVO) smc.queryForObject("clientMyPage.getMyPage",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mypageVO;
	}
	
	

}
