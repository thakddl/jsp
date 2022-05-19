package reply.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import reply.vo.ReplyVO;
import util.SqlMapClientFactory;

public class LineFeedReplyDaoImpl implements ILineFeedReplyDao{
	private static ILineFeedReplyDao replyDao;
	private SqlMapClient smc;
	
	private LineFeedReplyDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ILineFeedReplyDao getInstance() {
		if (replyDao == null) {
			replyDao = new LineFeedReplyDaoImpl();
		}
		return replyDao;
	}
	
	@Override
	public int insertReply(ReplyVO rv) throws SQLException {
		int cnt = 0;
		
		smc.insert("reply.insertLineFeed", rv);
		
		return cnt;
	}

	@Override
	public List<ReplyVO> getAllReply(ReplyVO rv) throws SQLException {
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		list = smc.queryForList("reply.getAllReply", rv);
		
		return list;
	}

	@Override
	public int updateReply(ReplyVO rv) throws SQLException {
		int cnt = 0;
		
		cnt = (int) smc.update("reply.updateReply", rv);
		
		return cnt;
	}

	@Override
	public int deleteReply(ReplyVO rv) throws SQLException {
		int cnt = 0;
		
		cnt = (int) smc.delete("reply.deleteReply", rv);
		
		return cnt;
	}

}
