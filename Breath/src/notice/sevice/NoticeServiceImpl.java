package notice.sevice;

import java.util.List;
import java.util.Map;

import notice.dao.INoticeDao;
import notice.dao.NoticeDaoImpl;
import notice.vo.NoticeVO;

public class NoticeServiceImpl implements INoticeService {

	private static INoticeService service;
	private INoticeDao dao;
	
	public NoticeServiceImpl() {
		dao = NoticeDaoImpl.getInstance();
	}

	public static INoticeService getInstance() {
		if (service == null) {
			service = new NoticeServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<NoticeVO> noticeList() {
		return dao.noticeList();
	}

	@Override
	public NoticeVO noticeDetail(String postNum) {
		return dao.noticeDetail(postNum);
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		return dao.insertNotice(vo);
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		return dao.updateNotice(vo);
	}

	@Override
	public int deleteNotice(String postNum) {
		return dao.deleteNotice(postNum);
	}

	
	
//	@Override
//	public int countList() {
//		return dao.countList();
//	}
//
//	@Override
//	public List<NoticeVO> noticeList(Map<String, Integer> map) {
//		return dao.noticeList(map);
//	}

}
