package qnaboard.service;

import java.util.List;

import qnaboard.vo.qnaBoardReplyVO;
import qnaboard.vo.qnaBoardVO;

public interface IBoardReplyService {
	public List<qnaBoardReplyVO> getReplyList();
	
	public List<qnaBoardReplyVO> getReply(String post_num);

	public int insertBoard(qnaBoardReplyVO bv);
	
	public int updateBoard(qnaBoardReplyVO bv);
	
	public int deleteBoard(String comment_num);
}
