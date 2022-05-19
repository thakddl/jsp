package lecture.Service;

import java.util.List;

import lecture.DAO.ILectureDAO;
import lecture.DAO.lectureDAOImpl;
import lecture.vo.BookInfoVO;
import lecture.vo.CourseVO;
import lecture.vo.LHistoryVO;
import lecture.vo.LectureJoinVO;
import lecture.vo.LectureVO;
import lecture.vo.categoryVO;

public class lectureServiceImpl implements ILectureService{

	private static ILectureService lectureService;
	private ILectureDAO lectureDAO;
	
	private lectureServiceImpl() {
		lectureDAO = lectureDAOImpl.getInstance();
	}
	
	public static ILectureService getInstance() {
		if(lectureService == null) {
			lectureService = new lectureServiceImpl();
		}
		return lectureService;
	}
	
	@Override
	public List<categoryVO> getCategoryName() {
		return lectureDAO.getCategoryName();
	}
	
	@Override
	public List<BookInfoVO> getBookList(String categoryId) {
		return lectureDAO.getBookList(categoryId);
	}

	@Override
	public int insertRequest(CourseVO cv) {
		return lectureDAO.insertRequest(cv);
	}

	@Override
	public List<CourseVO> displayRequestList() {
		return lectureDAO.displayRequestList();
	}

	@Override
	public CourseVO getDetail(String courseId) {
		return lectureDAO.getDetail(courseId);
	}

	@Override
	public int deleteLecture(String courseId) {
		return lectureDAO.deleteLecture(courseId);
	}

	@Override
	public int updateRequest(CourseVO cv) {
		return lectureDAO.updateRequest(cv);
	}

	@Override
	public int insertLecture(LectureVO lv) {
		return lectureDAO.insertLecture(lv);
	}

	@Override
	public List<CourseVO> getCourseList() {
		return lectureDAO.getCourseList();
	}

	@Override
	public int insertHistory(LHistoryVO lhv) {
		return lectureDAO.insertHistory(lhv);
	}

	@Override
	public List<CourseVO> getBuyCourseList(String memId) {
		return lectureDAO.getBuyCourseList(memId);
	}

	@Override
	public List<LectureVO> lectureList(String courseId) {
		return lectureDAO.lectureList(courseId);
	}
	

}
