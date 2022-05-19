package linefeed.service;

import java.util.List;

import linefeed.dao.ILineFeedDao;
import linefeed.dao.LineFeedDaoImpl;
import linefeed.vo.LineFeedVO;

public class LineFeedServiceImpl implements ILineFeedService{
	// 필드 선언
	public static ILineFeedService lineFeedService;
	private ILineFeedDao lineFeedDao;
	
	// 생성자 선언
	private LineFeedServiceImpl() {
		lineFeedDao = LineFeedDaoImpl.getInstance();
	}
	
	// 메소드 선언 및 구현
	public static ILineFeedService getInstance() {
		if (lineFeedService == null) {
			lineFeedService = new LineFeedServiceImpl();
		}
		return lineFeedService;
	}
	
	@Override
	public int insertLineFeed(LineFeedVO lv) {
		return lineFeedDao.insertLineFeed(lv);
	}

	@Override
	public int updateLineFeed(LineFeedVO lv) {
		return lineFeedDao.updateLineFeed(lv);
	}

	@Override
	public int deleteLineFeed(LineFeedVO lv) {
		return lineFeedDao.deleteLineFeed(lv);
	}

	@Override
	public List<LineFeedVO> getAllPostList(LineFeedVO lv) {
		return lineFeedDao.getAllPostList(lv);
	}

}
