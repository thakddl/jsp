package QuestionBoard.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import QuestionBoard.VO.QuestionBoardVO;
import QuestionReply.VO.QuestionReplyVO;

public interface IQuestionBoardDAO {
	public List<QuestionBoardVO> displayBoard();
	
	public int writeText(QuestionBoardVO bv);
	
	public int updateText(QuestionBoardVO bv);
	
	public int deleteText(QuestionBoardVO bv);
	
	public boolean isExist(String postId);
	
	public List<QuestionBoardVO> searchText(QuestionBoardVO bv);
	
	public QuestionBoardVO getDetail(QuestionBoardVO bv);

	public int countList() throws SQLException;
	
	public List<QuestionBoardVO> boardList(Map<String, Integer> map) throws SQLException;
	
	public String getPostMemId(QuestionBoardVO bv);
	
	public void plusPostViews(QuestionBoardVO bv);
	
	public void plusPointPost(QuestionBoardVO bv);
	
	public void plusPointReply(QuestionReplyVO rv);
	
	public void minusPointPost(QuestionBoardVO bv);
	
	public void minusPointReply(QuestionReplyVO rv);
	
	public void plusCoinPost(QuestionBoardVO bv);
	
	public void plusCoinReply(QuestionReplyVO rv);
	
	public void minusCoinPost(QuestionBoardVO bv);
	
	public void minusCoinReply(QuestionReplyVO rv);
	
	public void eliteMember();
	
	public void commonMember();
	
	public void plusPointPostHistory(String memId);
	
	public void plusPointReplyHistory(String memId);
	
	public void minusPointPostHistory(String memId);
	
	public void minusPointReplyHistory(String memId);
		
	//댓글 저장 - renum 리턴
	public int insertReply(QuestionReplyVO vo) throws SQLException;
	
	//댓글 리스트 조회
	public List<QuestionReplyVO> replyList(QuestionReplyVO vo);
	
	//댓글 수정
	public int replyUpdate(QuestionReplyVO vo) throws SQLException;
	
	//댓글 삭제
	public int replyDelete(QuestionReplyVO vo) throws SQLException;
	
}
