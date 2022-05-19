package Board.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import Board.VO.BoardVO;
import Reply.VO.ReplyVO;

public class BoardDAOImpl implements IBoardDAO{

	private static IBoardDAO BoardDAO;
	private SqlMapClient smc;
	
	private BoardDAOImpl() {
		smc = Util.SqlMapClientFactory.getInstance();
	}
	
	public static IBoardDAO getInstance() {
		if (BoardDAO == null) {
			BoardDAO = new BoardDAOImpl();
		}
		return BoardDAO;
	}

	@Override
	public List<BoardVO> displayBoard() {
		
		List<BoardVO> list = new ArrayList<BoardVO>(); 
		
		try {
			list = smc.queryForList("board.displayFreeBoard");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public List<BoardVO> displayBoard2(String boardId) {
		
		List<BoardVO> list = new ArrayList<BoardVO>(); 
		
		try {
			list = smc.queryForList("board.displayQABoard",boardId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int writeText(BoardVO bv) {
		int cnt = 0;
			
		try {
			cnt = smc.update("board.writeText",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateText(BoardVO bv) {
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
	public int deleteText(BoardVO bv) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("board.deleteText", bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			  
		return cnt;
	}

	@Override
	public List<BoardVO> searchText(BoardVO bv) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			list = smc.queryForList("board.searchText", bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public BoardVO getDetail(BoardVO bv) {
		BoardVO bv2 = new BoardVO();
		
		try {
			//인수는 무조건 2개여야함
			bv2 = (BoardVO) smc.queryForObject("board.getDetail",bv);
			
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
	public List<BoardVO> boardList(Map<String, Integer> map) throws SQLException {
		return smc.queryForList("board.boardList", map);
	}

	@Override
	public void plusPostViews(BoardVO bv) {
		
		try {
			smc.update("board.plusPostViews",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int insertReply(ReplyVO vo) throws SQLException {
		return smc.update("board.insertReply", vo);
	}

	@Override
	public List<ReplyVO> replyList(ReplyVO vo) {
		List<ReplyVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("board.replyList",vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int replyUpdate(ReplyVO vo) throws SQLException {
		return smc.update("board.replyUpdate", vo);
	}

	@Override
	public int replyDelete(ReplyVO vo) throws SQLException {
		return smc.delete("board.replyDelete", vo);
	}

	@Override
	public void plusPointPost(BoardVO bv) {
		try {
			smc.update("board.plusPointPost",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void plusPointReply(ReplyVO rv) {
		try {
			smc.update("board.plusPointReply",rv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void minusPointPost(BoardVO bv) {
		try {
			smc.update("board.minusPointPost",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void minusPointReply(ReplyVO rv) {
		try {
			smc.update("board.minusPointReply",rv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String getPostMemId(BoardVO bv) {
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
	public void plusCoinPost(BoardVO bv) {
		try {
			smc.update("board.plusCoinPost",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void plusCoinReply(ReplyVO rv) {
		try {
			smc.update("board.plusCoinReply",rv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void minusCoinPost(BoardVO bv) {
		try {
			smc.update("board.minusCoinPost",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void minusCoinReply(ReplyVO rv) {
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

	@Override
	public void minusCoinSelection(BoardVO bv) {
		try {
			smc.update("board.minusCoinSelection",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void plusCoinSelection(BoardVO bv) {
		try {
			smc.update("board.plusCoinSelection",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
