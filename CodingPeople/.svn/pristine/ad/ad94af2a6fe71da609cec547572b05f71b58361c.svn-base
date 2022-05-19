package Board.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Board.DAO.BoardDAOImpl;
import Board.DAO.IBoardDAO;
import Board.VO.BoardVO;
import Reply.VO.ReplyVO;

public class BoardServiceImpl implements IBoardService{
	
	private static IBoardService boardService;
	private IBoardDAO boardDAO;
	
	
	private BoardServiceImpl() {
		boardDAO = BoardDAOImpl.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(boardService == null) {
			boardService = new BoardServiceImpl();
		}
		
		return boardService;
	}
	
	@Override
	public List<BoardVO> displayBoard() {
		return boardDAO.displayBoard();
	}
	
	@Override
	public List<BoardVO> displayBoard2(String boardId) {
		return boardDAO.displayBoard2(boardId);
	}

	@Override
	public int writeText(BoardVO bv) {
		return boardDAO.writeText(bv);
	}

	@Override
	public int updateText(BoardVO bv) {
		return boardDAO.updateText(bv);
	}

	@Override
	public int deleteText(BoardVO bv) {
		return boardDAO.deleteText(bv);
	}

	@Override
	public boolean isExist(String postId) {
		return boardDAO.isExist(postId);
	}

	@Override
	public List<BoardVO> searchText(BoardVO bv) {
		return boardDAO.searchText(bv);
	}

	@Override
	public BoardVO getDetail(BoardVO bv) {
		return boardDAO.getDetail(bv);
	}

	@Override
	public int countList() {
		
		int count = 0;
		
		try {
			count = boardDAO.countList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<BoardVO> boardList(Map<String, Integer> map) {
		List<BoardVO> list = null;
		
		try {
			list = boardDAO.boardList(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public void plusPostViews(BoardVO bv) {
		boardDAO.plusPostViews(bv);
	}

	@Override
	public int insertReply(ReplyVO vo) {
		int seq = 0;
		try {
			seq = boardDAO.insertReply(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seq;
	}

	@Override
	public List<ReplyVO> replyList(ReplyVO vo){
		
			return boardDAO.replyList(vo);
	}

	@Override
	public int replyDelete(ReplyVO vo) {
		int del = 0;
		try {
			del = boardDAO.replyDelete(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return del;
	}

	@Override
	public int replyUpdate(ReplyVO vo) {
		int udt = 0;
		try {
			udt = boardDAO.replyUpdate(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return udt;
	}

	@Override
	public void plusPointPost(BoardVO bv) {
		boardDAO.plusPointPost(bv);
	}

	@Override
	public void plusPointReply(ReplyVO rv) {
		boardDAO.plusPointReply(rv);
	}

	@Override
	public void minusPointPost(BoardVO bv) {
		boardDAO.minusPointPost(bv);
	}

	@Override
	public void minusPointReply(ReplyVO rv) {
		boardDAO.minusPointReply(rv);
	}

	@Override
	public String getPostMemId(BoardVO bv) {
		return boardDAO.getPostMemId(bv);
	}

	@Override
	public void plusPointPostHistory(String memId) {
		boardDAO.plusPointPostHistory(memId);
	}

	@Override
	public void plusPointReplyHistory(String memId) {
		boardDAO.plusPointReplyHistory(memId);
	}

	@Override
	public void minusPointPostHistory(String memId) {
		boardDAO.minusPointPostHistory(memId);
	}

	@Override
	public void minusPointReplyHistory(String memId) {
		boardDAO.minusPointReplyHistory(memId);
	}

	@Override
	public void plusCoinPost(BoardVO bv) {
		boardDAO.plusCoinPost(bv);
	}

	@Override
	public void plusCoinReply(ReplyVO rv) {
		boardDAO.plusCoinReply(rv);
	}

	@Override
	public void minusCoinPost(BoardVO bv) {
		boardDAO.minusCoinPost(bv);
	}

	@Override
	public void minusCoinReply(ReplyVO rv) {
		boardDAO.minusCoinReply(rv);
	}

	@Override
	public void eliteMember() {
		boardDAO.eliteMember();
	}

	@Override
	public void commonMember() {
		boardDAO.commonMember();
	}

	@Override
	public void minusCoinSelection(BoardVO bv) {
		boardDAO.minusCoinSelection(bv);
	}

	@Override
	public void plusCoinSelection(BoardVO bv) {
		boardDAO.plusCoinSelection(bv);
	}
}
