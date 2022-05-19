package coin.service;

import java.util.List;

import book.VO.BbuyHistoryVO;
import book.VO.BookInfoVO;
import book.VO.BsellHistoryVO;
import coin.vo.CoinHistoryVO;
import coin.vo.MemberVO;
import point.history.VO.PointHistoryVO;

public interface IcoinService {
	
	public MemberVO getMember(String memId);
	
	public int updateCoin(MemberVO memVO);
	
	public int insertCoinHistory(CoinHistoryVO cHistoryVO);
	
	public String getChistroySeq();

	public List<CoinHistoryVO> getCHistoryList(String memId);
	
	public List<PointHistoryVO> getPHistoryList(String memId);

	public List<BbuyHistoryVO> getBbuyHistoryVO(String memId);
	
	public List<BsellHistoryVO> getBsellHistoryVO(String memId);
	
	public BookInfoVO getBookInfoVO(String bookInfoId);

}
