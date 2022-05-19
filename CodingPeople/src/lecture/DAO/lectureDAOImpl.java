package lecture.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import Util.SqlMapClientFactory;
import coin.vo.CoinHistoryVO;
import lecture.vo.BookInfoVO;
import lecture.vo.CourseVO;
import lecture.vo.LHistoryVO;
import lecture.vo.LectureVO;
import lecture.vo.categoryVO;

public class lectureDAOImpl implements ILectureDAO{

	private static ILectureDAO lectureDAO;
	private SqlMapClient smc;
	
	private lectureDAOImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ILectureDAO getInstance() {
		if(lectureDAO == null) {
			lectureDAO = new lectureDAOImpl();
		}
		return lectureDAO;
	}
		
	@Override
	public List<categoryVO> getCategoryName() {
		List<categoryVO> list = new ArrayList<categoryVO>();
		
		try {
			list = smc.queryForList("lecture.getCategory");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public List<BookInfoVO> getBookList(String categoryId) {
		
		List<BookInfoVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("lecture.getBookList", categoryId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public int insertRequest(CourseVO cv) {
		
		int cnt = 0;
		
		try {
			String courseId = (String) smc.queryForObject("lecture.getUniqueId",cv.getCategoryId());
			String courseId2 = cv.getCategoryId() +" " + (Integer.parseInt(courseId.substring(courseId.indexOf(" ")+1))+1);
			cv.setCourseId(courseId2);
			
			cnt = smc.update("lecture.insertRequest",cv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<CourseVO> displayRequestList() {
		List<CourseVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("lecture.displayRequestList");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public CourseVO getDetail(String courseId) {
		CourseVO lv = new CourseVO();
		
		try {
			lv = (CourseVO) smc.queryForObject("lecture.getDetail",courseId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lv;
	}

	@Override
	public int deleteLecture(String courseId) {
		int c = 0;
		
		try {
			c = smc.delete("lecture.deleteLecture",courseId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public int updateRequest(CourseVO cv) {
		int c = 0;
		
		try {
			c= smc.update("lecture.updateRequest",cv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public int insertLecture(LectureVO lv) {
		int c = 0;
		try {
			smc.update("lecture.insertLecture",lv);
			//coursetable의 승인상태를 판매중으로 바꾸는 메소드
			c = smc.update("lecture.updateState",lv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<CourseVO> getCourseList() {
		List<CourseVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("lecture.getCourseList");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insertHistory(LHistoryVO lhv) {
		
		int c = 0;
		// mem1 : 구매자 mem2 : 판매자
		try {
			int memCoin = (int) smc.queryForObject ("lecture.getBuyerCoin", lhv.getMemId());
			if(memCoin < Integer.parseInt(lhv.getCoursePrice())) {
				return -1;
			}
			LHistoryVO lhv2 = new LHistoryVO();
			int mem2Coin = (int)smc.queryForObject("lecture.getSellerCoin", lhv.getCourseId());
			lhv2.setMemCoin(mem2Coin+"");
			smc.update("lecture.insertBHistory",lhv);
			smc.update("lecture.insertCstudent",lhv);
			
			memCoin = memCoin - Integer.parseInt(lhv.getCoursePrice());
			lhv.setMemCoin(memCoin+"");
			lhv2.setCoursePrice(lhv.getCoursePrice());
			lhv2.setCourseId(lhv.getCourseId());
			lhv2.setCourseTitle(lhv.getCourseTitle().replace("구", "판"));
			smc.update("lecture.insertSHistory",lhv2);
			smc.update("lecture.insertSellerCoinHistory",lhv2);
			smc.update("lecture.insertBuyerCoinHistory",lhv);
			smc.update("lecture.updateSellerCoin",lhv2);
			c = smc.update("lecture.updateBuyerCoin",lhv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<CourseVO> getBuyCourseList(String memId) {
		List<CourseVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("lecture.getBuyCourseList",memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<LectureVO> lectureList(String courseId) {
		List<LectureVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("lecture.lectureList",courseId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
