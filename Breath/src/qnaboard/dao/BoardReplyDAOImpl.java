package qnaboard.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import qnaboard.vo.qnaBoardReplyVO;
import qnaboard.vo.qnaBoardVO;
import util.SqlMapClientFactory;

public class BoardReplyDAOImpl implements IBoardReplyDAO{
	public static IBoardReplyDAO dao;
	private SqlMapClient smc;
	// 생성자 선언(싱글톤)
	private BoardReplyDAOImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	// 메소드 선언 및 구현 
	public static IBoardReplyDAO getInstance() {
		if (dao == null) {
			dao = new BoardReplyDAOImpl();
		}
		return dao;
	}
	@Override
	public List<qnaBoardReplyVO> getReplyList() {
		List<qnaBoardReplyVO> replyList = new ArrayList<qnaBoardReplyVO>();
		
		try {
			replyList = smc.queryForList("qnaBoard.getBoardReply");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return replyList;
	}
	@Override
	public List<qnaBoardReplyVO> getReply(String post_num) {
		List<qnaBoardReplyVO> qbv = new ArrayList<>();
		try {
			qbv = smc.queryForList("qnaBoard.getBoardReply", post_num);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qbv;
	}
	@Override
	public int insertBoard(qnaBoardReplyVO brv) {
		int cnt=0;
		try {
			cnt = smc.update("qnaBoard.insertBoardReply", brv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int updateBoard(qnaBoardReplyVO bv) {
		return 0;
	}
	@Override
	public int deleteBoard(String comment_num) {
		return 0;
	}
	
}
