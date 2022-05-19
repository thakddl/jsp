package membership.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import membership.vo.MembershipVO;
import util.SqlMapClientFactory;

public class MembershipDaoImpl implements IMembershipDao {
	
	private SqlMapClient smc;
	
	private static IMembershipDao dao;
	
	public MembershipDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IMembershipDao getInstance() {
		if (dao == null) {
			dao = new MembershipDaoImpl();
		}
		return dao;
	}
	

	@Override
	public int inserMembership(MembershipVO mv) {
		int cnt = 0;
		try {
			cnt = smc.update("membership.insertMembership", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateAthrt(String memId) {
		int cnt = 0;
		try {
			cnt = smc.update("membership.updateAthrt", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MembershipVO> getShipList(String memId) {
		List<MembershipVO> list = new ArrayList<>();
		
		try {
			list = (List<MembershipVO>) smc.queryForList("membership.getShipList", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public MembershipVO getShipDetail(String memId) {
		MembershipVO vo = new MembershipVO();
		
		try {
			vo = (MembershipVO) smc.queryForObject("membership.getShipDetail", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int shipCount() {
		int cnt = 0;
		
		try {
			cnt = (int) smc.queryForObject("membership.shipCount");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	
	
	
	
}
