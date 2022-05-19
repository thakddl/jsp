package qnaboard.dao;

import java.util.List;

import qnaboard.vo.qnaBoardReplyVO;

public interface IBoardReplyDAO {
	public List<qnaBoardReplyVO> getReplyList();
	
	public List<qnaBoardReplyVO> getReply(String post_num);
	
	public int insertBoard(qnaBoardReplyVO brv);
	
	public int updateBoard(qnaBoardReplyVO brv);
	
	public int deleteBoard(String comment_num);
}
