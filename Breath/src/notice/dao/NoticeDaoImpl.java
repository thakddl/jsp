package notice.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import notice.vo.NoticeVO;
import util.SqlMapClientFactory;

public class NoticeDaoImpl implements INoticeDao {
	
	private SqlMapClient smc;
	
	private static INoticeDao dao;
	
	public NoticeDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static INoticeDao getInstance() {
		if (dao == null) {
			dao = new NoticeDaoImpl();
		}
		return dao;
	}

	@Override
	public List<NoticeVO> noticeList() {
		List<NoticeVO> list = null;
		
		try {
			list = smc.queryForList("notice.noticeList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public NoticeVO noticeDetail(String postNum) {
		
		NoticeVO nv = new NoticeVO();
		
		try {
			nv = (NoticeVO) smc.queryForObject("notice.noticeDetail", postNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nv;
	}
	
	@Override
	public int insertNotice(NoticeVO vo) {
		int cnt = 0;
		
		try {
			cnt = (int) smc.update("notice.insertNotice", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		int cnt = 0;
		
		try {
			cnt = (int) smc.update("notice.updateNotice", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteNotice(String postNum) {
		int cnt = 0;
		
		try {
			cnt = (int) smc.update("notice.deleteNotice", postNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}


	
	
	// Web 수업 참조
//	@Override
//	public int countList() {
//		int cnt = 0;
//		
//		try {
//			cnt = (int) smc.queryForObject("notice.countList");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return cnt;
//	}
//
//	@Override
//	public List<NoticeVO> noticeList(Map<String, Integer> map) {
//		List<NoticeVO> list = new ArrayList<>();
//		
//		try {
//			list = (List<NoticeVO>) smc.queryForObject("notice.noticeList");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
	
	


}