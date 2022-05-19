package qnaboard.service;

import java.util.List;

import qnaboard.dao.BoardReplyDAOImpl;
import qnaboard.dao.IBoardReplyDAO;
import qnaboard.vo.qnaBoardReplyVO;

public class BoardReplyServiceImpl implements IBoardReplyService{
	public static IBoardReplyService service;
	private IBoardReplyDAO dao;
	
	private BoardReplyServiceImpl() {
		dao = BoardReplyDAOImpl.getInstance();
	}
	
	public static IBoardReplyService getInstance() {
		if (service == null) {
			service = new BoardReplyServiceImpl();
		}
		return service;
	}

	@Override
	public List<qnaBoardReplyVO> getReplyList() {
		return dao.getReplyList();
	}

	@Override
	public int insertBoard(qnaBoardReplyVO brv) {
		return dao.insertBoard(brv);
	}

	@Override
	public int updateBoard(qnaBoardReplyVO bv) {
		return 0;
	}

	@Override
	public int deleteBoard(String comment_num) {
		return 0;
	}

	@Override
	public List<qnaBoardReplyVO> getReply(String post_num) {
		return dao.getReply(post_num);
				
	}
}
