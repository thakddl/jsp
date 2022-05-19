package qnaboard.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import qnaboard.vo.qnaBoardVO;
import util.SqlMapClientFactory;

public class BoardDAOImpl implements IBoardDAO {
	public static IBoardDAO dao;
	private SqlMapClient smc;
	// 생성자 선언(싱글톤)
	private BoardDAOImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	// 메소드 선언 및 구현 
	public static IBoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAOImpl();
		}
		return dao;
	}
	@Override
	public List<qnaBoardVO> selectList() {
		
		List<qnaBoardVO> boardList = new ArrayList<qnaBoardVO>();
		
			try {
				boardList = smc.queryForList("qnaBoard.getBoard");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return boardList;
	}
	@Override
	public qnaBoardVO getContent(String post_num) {
		qnaBoardVO bv = new qnaBoardVO();
		try {
			bv = (qnaBoardVO)smc.queryForObject("qnaBoard.selectBoard", post_num);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bv;
	}
	@Override
	public int insertBoard(qnaBoardVO bv) {
		int cnt=0;
		try {
			cnt = smc.update("qnaBoard.insertBoard", bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int updateBoard(qnaBoardVO bv) {
		int cnt=0;
		try {
			cnt = smc.update("qnaBoard.updateBoard", bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int deleteBoard(String post_num) {
		int cnt=0;
		try {
			cnt = smc.update("qnaBoard.deleteBoard", post_num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	
}
