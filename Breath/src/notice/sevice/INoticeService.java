package notice.sevice;

import java.util.List;
import java.util.Map;

import notice.vo.NoticeVO;

public interface INoticeService {

	// 공지사항 리스트
	public List<NoticeVO> noticeList();
	
	// 공지사항 상세정보
	public NoticeVO noticeDetail(String postNum);
	
	// 공지사항 작성
	public int insertNotice(NoticeVO vo);
	
	// 공지사항 수정
	public int updateNotice(NoticeVO vo);
	
	// 공지사항 삭제
	public int deleteNotice(String postNum);
	
//	// 전체 글 갯수 가져오기
//	public int countList();
//	
//	// 페이지 별 리스트 가져오기
//	public List<NoticeVO> noticeList(Map<String, Integer> map);
	
}
