package pay.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import pay.vo.BuyerVO;
import pay.vo.PayVO;
import util.SqlMapClientFactory;

public class PayDaoImpl implements IPayDao {
	
	
	private SqlMapClient smc;
	
	private static IPayDao dao;
	
	public PayDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IPayDao getInstance() {
		if (dao == null) {
			dao = new PayDaoImpl();
		}
		return dao;
	}
	
	
	@Override
	public BuyerVO getBuyerInfo(String memId, String trainerId) {
		
		BuyerVO vo = null;
		
		try {
			vo = (BuyerVO) smc.queryForObject("pay.buyerInfo", memId, trainerId);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return vo;
	}

	@Override
	public int inserPay(PayVO pv) {
		int cnt = 0;
		
		try {
			cnt = smc.update("pay.insertPay", pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

}
