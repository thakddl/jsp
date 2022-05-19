package QuestionBoard.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import QuestionBoard.DAO.QuestionBoardDAOImpl;
import QuestionBoard.DAO.IQuestionBoardDAO;
import QuestionBoard.VO.QuestionBoardVO;
import QuestionReply.VO.QuestionReplyVO;

public class QuestionBoardServiceImpl implements IQuestionBoardService{
	
	private static IQuestionBoardService boardService;
	private IQuestionBoardDAO boardDAO;
	
	
	private QuestionBoardServiceImpl() {
		boardDAO = QuestionBoardDAOImpl.getInstance();
	}
	
	public static IQuestionBoardService getInstance() {
		if(boardService == null) {
			boardService = new QuestionBoardServiceImpl();
		}
		
		return boardService;
	}
	
	@Override
	public List<QuestionBoardVO> displayBoard() {
		return boardDAO.displayBoard();
	}

	@Override
	public int writeText(QuestionBoardVO bv) {
		return boardDAO.writeText(bv);
	}

	@Override
	public int updateText(QuestionBoardVO bv) {
		return boardDAO.updateText(bv);
	}

	@Override
	public int deleteText(QuestionBoardVO bv) {
		return boardDAO.deleteText(bv);
	}

	@Override
	public boolean isExist(String postId) {
		return boardDAO.isExist(postId);
	}

	@Override
	public List<QuestionBoardVO> searchText(QuestionBoardVO bv) {
		return boardDAO.searchText(bv);
	}

	@Override
	public QuestionBoardVO getDetail(QuestionBoardVO bv) {
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
	public List<QuestionBoardVO> boardList(Map<String, Integer> map) {
		List<QuestionBoardVO> list = null;
		
		try {
			list = boardDAO.boardList(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void plusPostViews(QuestionBoardVO bv) {
		boardDAO.plusPostViews(bv);
	}

	@Override
	public int insertReply(QuestionReplyVO vo) {
		int seq = 0;
		try {
			seq = boardDAO.insertReply(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seq;
	}

	@Override
	public List<QuestionReplyVO> replyList(QuestionReplyVO vo){
		
			return boardDAO.replyList(vo);
	}

	@Override
	public int replyDelete(QuestionReplyVO vo) {
		int del = 0;
		try {
			del = boardDAO.replyDelete(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return del;
	}

	@Override
	public int replyUpdate(QuestionReplyVO vo) {
		int udt = 0;
		try {
			udt = boardDAO.replyUpdate(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return udt;
	}

	@Override
	public void plusPointPost(QuestionBoardVO bv) {
		boardDAO.plusPointPost(bv);
	}

	@Override
	public void plusPointReply(QuestionReplyVO rv) {
		boardDAO.plusPointReply(rv);
	}

	@Override
	public void minusPointPost(QuestionBoardVO bv) {
		boardDAO.minusPointPost(bv);
	}

	@Override
	public void minusPointReply(QuestionReplyVO rv) {
		boardDAO.minusPointReply(rv);
	}

	@Override
	public String getPostMemId(QuestionBoardVO bv) {
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
	public void plusCoinPost(QuestionBoardVO bv) {
		boardDAO.plusCoinPost(bv);
	}

	@Override
	public void plusCoinReply(QuestionReplyVO rv) {
		boardDAO.plusCoinReply(rv);
	}

	@Override
	public void minusCoinPost(QuestionBoardVO bv) {
		boardDAO.minusCoinPost(bv);
	}

	@Override
	public void minusCoinReply(QuestionReplyVO rv) {
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
}
