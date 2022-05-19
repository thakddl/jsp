package coin.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import Util.SqlMapClientFactory;
import book.VO.BbuyHistoryVO;
import book.VO.BookInfoVO;
import book.VO.BsellHistoryVO;
import coin.vo.CoinHistoryVO;
import coin.vo.MemberVO;
import point.history.VO.PointHistoryVO;

public class CoinDaoImpl implements IcoinDao{
	
	private SqlMapClient smc;
	private static IcoinDao coinDao;

	public CoinDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IcoinDao getInstance() {
		if(coinDao == null) {
			coinDao = new CoinDaoImpl();
		}
		return coinDao;
	}
	
	@Override
	public MemberVO getMember(String memId) {
		MemberVO memVO = null;
		try {
			memVO = (MemberVO) smc.queryForObject("member.getMember", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memVO;
	}

	@Override
	public int updateCoin(MemberVO memVO) {
		int cnt = 0;
		try {
			cnt = smc.update("member.updateCoin", memVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertCoinHistory(CoinHistoryVO cHistoryVO) {
		int cnt = 0;
		try {
			cnt = smc.update("member.insertCoinHistory",cHistoryVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String getChistroySeq() {
		String currval = null;
		try {
			currval = (String) smc.queryForObject("member.getChistroySeq");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currval;
	}

	@Override
	public List<CoinHistoryVO> getCHistoryList(String memId) {
		List<CoinHistoryVO> list = null;
		try {
			list = smc.queryForList("member.getCHistoryList", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<PointHistoryVO> getPHistoryList(String memId) {
		List<PointHistoryVO> list = null;
		try {
			list = smc.queryForList("member.getPHistoryList",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BbuyHistoryVO> getBbuyHistoryVO(String memId) {
		List<BbuyHistoryVO> list = null;
		try {
			list = smc.queryForList("member.getBbuyHistoryVO",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BsellHistoryVO> getBsellHistoryVO(String memId) {
		List<BsellHistoryVO> list = null;
		try {
			list = smc.queryForList("member.getBsellHistoryVO",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BookInfoVO getBookInfoVO(String bookInfoId) {
		BookInfoVO vo = null;
		try {
			vo = (BookInfoVO) smc.queryForObject("member.getBookInfoVO",bookInfoId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(vo);
		System.out.println(bookInfoId);
		return vo;
	}

}
