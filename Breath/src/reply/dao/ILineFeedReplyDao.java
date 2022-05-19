package reply.dao;

import java.sql.SQLException;
import java.util.List;

import reply.vo.ReplyVO;

public interface ILineFeedReplyDao {
	/**
	 * 댓글을 등록하는 메서드
	 * @param rv 등록 내용을 담은 ReplyVO 객체
	 * @return 작업성공: 1, 작업실패 : 0
	 */
	public int insertReply(ReplyVO rv) throws SQLException;
	
	/**
	 * 모든 댓글 목록을 불러오는 메서드
	 * @param rv
	 * @return 댓글 내용이 담겨있는 list 객체
	 */
	public List<ReplyVO> getAllReply(ReplyVO rv) throws SQLException;
	
	/**
	 * 댓글 내용을 수정하는 메서드
	 * @param rv
	 * @return
	 */
	public int updateReply(ReplyVO rv) throws SQLException;
	
	/**
	 * 댓글을 삭제하는 메서드
	 * @param rv
	 * @return
	 */
	public int deleteReply(ReplyVO rv) throws SQLException;
}
