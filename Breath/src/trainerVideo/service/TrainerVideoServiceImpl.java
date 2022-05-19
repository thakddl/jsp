package trainerVideo.service;

import java.util.List;

import linefeed.dao.ILineFeedDao;
import linefeed.dao.LineFeedDaoImpl;
import linefeed.vo.LineFeedVO;
import trainerVideo.dao.ITrainerVideoDao;
import trainerVideo.dao.TrainerVideoDaoImpl;
import trainerVideo.vo.TrainerVideoVO;

public class TrainerVideoServiceImpl implements ITrainerVideoService{
	// 필드 선언
	public static ITrainerVideoService trainerVideoService;
	private ITrainerVideoDao trainerVideoDao;
	
	// 생성자 선언
	private TrainerVideoServiceImpl() {
		trainerVideoDao = TrainerVideoDaoImpl.getInstance();
	}
	
	// 메소드 선언 및 구현
	public static ITrainerVideoService getInstance() {
		if (trainerVideoService == null) {
			trainerVideoService = new TrainerVideoServiceImpl();
		}
		return trainerVideoService;
	}
	
	@Override
	public int insertVideo(TrainerVideoVO lv) {
		return trainerVideoDao.insertVideo(lv);
	}

	@Override
	public int updateVideo(TrainerVideoVO lv) {
		return trainerVideoDao.updateVideo(lv);
	}

	@Override
	public int deleteVideo(TrainerVideoVO lv) {
		return trainerVideoDao.deleteVideo(lv);
	}

	@Override
	public List<TrainerVideoVO> getAllVideoList(TrainerVideoVO lv) {
		return trainerVideoDao.getAllVideoList(lv);
	}

}
