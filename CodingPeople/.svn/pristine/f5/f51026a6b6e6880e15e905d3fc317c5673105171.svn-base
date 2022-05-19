package lecture.DAO;

import java.util.List;

import lecture.vo.BookInfoVO;
import lecture.vo.CourseVO;
import lecture.vo.LHistoryVO;
import lecture.vo.LectureJoinVO;
import lecture.vo.LectureVO;
import lecture.vo.categoryVO;

public interface ILectureDAO {

	public List<categoryVO> getCategoryName();
	
	public List<BookInfoVO> getBookList(String categoryId);
	
	public int insertRequest(CourseVO cv);
	
	public List<CourseVO> displayRequestList();
	
	public CourseVO getDetail(String courseId);
	
	public int deleteLecture(String courseId);
	
	public int updateRequest(CourseVO cv);
	
	public int insertLecture(LectureVO lv);
	
	public List<CourseVO> getCourseList();
	
	public int insertHistory(LHistoryVO lhv);
	
	public List<CourseVO> getBuyCourseList(String memId);
	
	public List<LectureVO> lectureList(String courseId);
}