package linefeed.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import linefeed.vo.LineFeedVO;
import util.SqlMapClientFactory;

public class LineFeedDaoImpl implements ILineFeedDao{
	// 필드 선언
	public static ILineFeedDao lineFeedDao;
	private SqlMapClient smc;
	
	// 생성자 선언(싱글톤)
	private LineFeedDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	// 메소드 선언 및 구현 
	
	public static ILineFeedDao getInstance() {
		if (lineFeedDao == null) {
			lineFeedDao = new LineFeedDaoImpl();
		}
		return lineFeedDao;
	}
	
	@Override
	public int insertLineFeed(LineFeedVO lv) {
		int cnt = 0;
		
		try {
			smc.insert("lineFeed.insertLineFeed", lv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateLineFeed(LineFeedVO lv) {
		int cnt = 0;
		
		try {
			cnt = (int) smc.update("lineFeed.updateLineFeed", lv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteLineFeed(LineFeedVO lv) {
		int cnt = 0;
		
		try {
			cnt = (int) smc.update("lineFeed.deleteLineFeed", lv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return cnt;
	}

	@Override
	public List<LineFeedVO> getAllPostList(LineFeedVO lv) {
		List<LineFeedVO> list = new ArrayList<LineFeedVO>();
		
		try {
			list = smc.queryForList("lineFeed.getAllPostList", lv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
