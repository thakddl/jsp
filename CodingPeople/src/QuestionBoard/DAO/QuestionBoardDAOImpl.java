package QuestionBoard.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import QuestionBoard.VO.QuestionBoardVO;
import QuestionReply.VO.QuestionReplyVO;

public class QuestionBoardDAOImpl implements IQuestionBoardDAO{

	private static IQuestionBoardDAO BoardDAO;
	private SqlMapClient smc;
	
	private QuestionBoardDAOImpl() {
		smc = Util.SqlMapClientFactory.getInstance();
	}
	
	public static IQuestionBoardDAO getInstance() {
		if (BoardDAO == null) {
			BoardDAO = new QuestionBoardDAOImpl();
		}
		return BoardDAO;
	}

	@Override
	public List<QuestionBoardVO> displayBoard() {
		
		List<QuestionBoardVO> list = new ArrayList<QuestionBoardVO>(); 
		
		try {
			list = smc.queryForList("questionboard.displayquestionBoard");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int writeText(QuestionBoardVO bv) {
		int cnt = 0;
			
		try {
			cnt = smc.update("board.writeText",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateText(QuestionBoardVO bv) {
		int cnt = 0;
		
		try {
			cnt = smc.update("board.updateText", bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			  
		return cnt;
	}
	
	@Override
	public boolean isExist(String postId) {
		boolean isExist = false;
		
		try {
			int cnt = smc.update("board.isExist",postId);
			
			if (cnt>0) {
				isExist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isExist;
	}

	@Override
	public int deleteText(QuestionBoardVO bv) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("board.deleteText", bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			  
		return cnt;
	}

	@Override
	public List<QuestionBoardVO> searchText(QuestionBoardVO bv) {
		List<QuestionBoardVO> list = new ArrayList<QuestionBoardVO>();
		
		try {
			list = smc.queryForList("board.searchText", bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public QuestionBoardVO getDetail(QuestionBoardVO bv) {
		QuestionBoardVO bv2 = new QuestionBoardVO();
		
		try {
			//인수는 무조건 2개여야함
			bv2 = (QuestionBoardVO) smc.queryForObject("questionboard.getDetail",bv);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bv2;
	}

	@Override
	public int countList() throws SQLException {
		return (int) smc.queryForObject("board.countList");
	}

	@Override
	public List<QuestionBoardVO> boardList(Map<String, Integer> map) throws SQLException {
		return smc.queryForList("board.boardList", map);
	}

	@Override
	public void plusPostViews(QuestionBoardVO bv) {
		
		try {
			smc.update("board.plusPostViews",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int insertReply(QuestionReplyVO vo) throws SQLException {
		return smc.update("questionboard.insertReply", vo);
	}

	@Override
	public List<QuestionReplyVO> replyList(QuestionReplyVO vo) {
		List<QuestionReplyVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("board.replyList",vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int replyUpdate(QuestionReplyVO vo) throws SQLException {
		return smc.update("board.replyUpdate", vo);
	}

	@Override
	public int replyDelete(QuestionReplyVO vo) throws SQLException {
		return smc.delete("board.replyDelete", vo);
	}

	@Override
	public void plusPointPost(QuestionBoardVO bv) {
		try {
			smc.update("board.plusPointPost",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void plusPointReply(QuestionReplyVO rv) {
		try {
			smc.update("board.plusPointReply",rv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void minusPointPost(QuestionBoardVO bv) {
		try {
			smc.update("board.minusPointPost",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void minusPointReply(QuestionReplyVO rv) {
		try {
			smc.update("board.minusPointReply",rv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String getPostMemId(QuestionBoardVO bv) {
		String memId = null;
		try {
			memId = (String) smc.queryForObject("board.getPostMemId",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memId;
	}

	@Override
	public void plusPointPostHistory(String memId) {
		try {
			smc.update("board.plusPointPostHistory",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void plusPointReplyHistory(String memId) {
		try {
			smc.update("board.plusPointReplyHistory",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void minusPointPostHistory(String memId) {
		try {
			smc.update("board.minusPointPostHistory",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void minusPointReplyHistory(String memId) {
		try {
			smc.update("board.minusPointReplyHistory",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void plusCoinPost(QuestionBoardVO bv) {
		try {
			smc.update("board.plusCoinPost",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void plusCoinReply(QuestionReplyVO rv) {
		try {
			smc.update("board.plusCoinReply",rv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void minusCoinPost(QuestionBoardVO bv) {
		try {
			smc.update("board.minusCoinPost",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void minusCoinReply(QuestionReplyVO rv) {
		try {
			smc.update("board.minusCoinReply",rv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliteMember() {
		try {
			smc.update("board.eliteMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void commonMember() {
		try {
			smc.update("board.commonMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
