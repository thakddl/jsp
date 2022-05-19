package coin.service;

import java.util.List;

import book.VO.BbuyHistoryVO;
import book.VO.BookInfoVO;
import book.VO.BsellHistoryVO;
import coin.dao.CoinDaoImpl;
import coin.dao.IcoinDao;
import coin.vo.CoinHistoryVO;
import coin.vo.MemberVO;
import point.history.VO.PointHistoryVO;

public class CoinServiceImpl implements IcoinService {

	private IcoinDao coinDao;
	private static IcoinService coinService;
	
	public CoinServiceImpl() {
		coinDao = CoinDaoImpl.getInstance();
	}

	public static IcoinService getInstance() {
		if(coinService == null) {
			coinService = new CoinServiceImpl();
		}
		return coinService;
	}
	
	@Override
	public MemberVO getMember(String memId) {
		return coinDao.getMember(memId);
	}

	@Override
	public int updateCoin(MemberVO memVO) {
		
		return coinDao.updateCoin(memVO);
	}

	@Override
	public int insertCoinHistory(CoinHistoryVO cHistoryVO) {
		return coinDao.insertCoinHistory(cHistoryVO);
	}

	@Override
	public String getChistroySeq() {
		return coinDao.getChistroySeq();
	}

	@Override
	public List<CoinHistoryVO> getCHistoryList(String memId) {
		return coinDao.getCHistoryList(memId);
	}

	@Override
	public List<PointHistoryVO> getPHistoryList(String memId) {
		return coinDao.getPHistoryList(memId);
	}

	@Override
	public List<BbuyHistoryVO> getBbuyHistoryVO(String memId) {
		return coinDao.getBbuyHistoryVO(memId);
	}

	@Override
	public List<BsellHistoryVO> getBsellHistoryVO(String memId) {
		return coinDao.getBsellHistoryVO(memId);
	}

	@Override
	public BookInfoVO getBookInfoVO(String bookInfoId) {
		return coinDao.getBookInfoVO(bookInfoId);
	}
	
	
}
