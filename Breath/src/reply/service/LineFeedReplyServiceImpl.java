package reply.service;

import java.sql.SQLException;
import java.util.List;

import reply.dao.ILineFeedReplyDao;
import reply.dao.LineFeedReplyDaoImpl;
import reply.vo.ReplyVO;

public class LineFeedReplyServiceImpl implements ILineFeedReplyService{
	private static ILineFeedReplyService replyService;
	private ILineFeedReplyDao replyDao;
	
	private LineFeedReplyServiceImpl() {
		replyDao = LineFeedReplyDaoImpl.getInstance();
	}
	
	public static ILineFeedReplyService getInstance() {
		if (replyService == null) {
			replyService = new LineFeedReplyServiceImpl();
		}
		return replyService;
	}

	@Override
	public int insertReply(ReplyVO rv) throws SQLException {
		return replyDao.insertReply(rv);
	}

	@Override
	public List<ReplyVO> getAllReply(ReplyVO rv) throws SQLException {
		return replyDao.getAllReply(rv);
	}

	@Override
	public int updateReply(ReplyVO rv) throws SQLException {
		return replyDao.updateReply(rv);
	}

	@Override
	public int deleteReply(ReplyVO rv) throws SQLException {
		return replyDao.deleteReply(rv);
	}

}
