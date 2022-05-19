package Board.Service;

import java.util.List;
import java.util.Map;

import Board.VO.BoardVO;
import Reply.VO.ReplyVO;

public interface IBoardService {
	public List<BoardVO> displayBoard();
	
	public List<BoardVO> displayBoard2(String boardId);
	
	public int writeText(BoardVO bv);
	
	public int updateText(BoardVO bv);
	
	public int deleteText(BoardVO bv);
	
	public boolean isExist(String postId);
	
	public List<BoardVO> searchText(BoardVO bv);
	
	public BoardVO getDetail(BoardVO bv);
	
	public int countList();
	
	public List<BoardVO> boardList(Map<String, Integer> map);
	
	public String getPostMemId(BoardVO bv);

	public void plusPostViews(BoardVO bv);
	
	public void plusPointPost(BoardVO bv);
	
	public void plusPointReply(ReplyVO rv);
	
	public void minusPointPost(BoardVO bv);
	
	public void minusPointReply(ReplyVO rv);
	
	public void plusCoinPost(BoardVO bv);
	
	public void plusCoinReply(ReplyVO rv);
	
	public void minusCoinPost(BoardVO bv);
	
	public void minusCoinReply(ReplyVO rv);
	
	public void minusCoinSelection(BoardVO bv);
	
	public void plusCoinSelection(BoardVO bv);
	
	public void eliteMember();
	
	public void commonMember();
	
	public void plusPointPostHistory(String memId);
	
	public void plusPointReplyHistory(String memId);
	
	public void minusPointPostHistory(String memId);
	
	public void minusPointReplyHistory(String memId);
	
	//댓글 저장 
	public int insertReply(ReplyVO vo);

	//댓글 리스트 조회
	public List<ReplyVO> replyList(ReplyVO vo);

	//댓글 삭제
	public int replyDelete(ReplyVO vo);

	//댓글 수정
	public int replyUpdate(ReplyVO vo);
}
