package trainerVideo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import trainerVideo.vo.TrainerVideoVO;
import util.SqlMapClientFactory;

public class TrainerVideoDaoImpl implements ITrainerVideoDao{
	// 필드 선언
	public static ITrainerVideoDao trainerVideoDao;
	private SqlMapClient smc;
	
	// 생성자 선언(싱글톤)
	private TrainerVideoDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	// 메소드 선언 및 구현 
	
	public static ITrainerVideoDao getInstance() {
		if (trainerVideoDao == null) {
			trainerVideoDao = new TrainerVideoDaoImpl();
		}
		return trainerVideoDao;
	}
	
	@Override
	public int insertVideo(TrainerVideoVO lv) {
		int cnt = 0;
		
		try {
			smc.insert("trainerVideo.insertVideo", lv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateVideo(TrainerVideoVO lv) {
		int cnt = 0;
		
		try {
			cnt = (int) smc.update("trainerVideo.updateVideo", lv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteVideo(TrainerVideoVO lv) {
		int cnt = 0;
		
		try {
			cnt = (int) smc.update("trainerVideo.deleteVideo", lv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return cnt;
	}

	@Override
	public List<TrainerVideoVO> getAllVideoList(TrainerVideoVO lv) {
		List<TrainerVideoVO> list = new ArrayList<TrainerVideoVO>();
		
		try {
			list = smc.queryForList("trainerVideo.getAllVideoList", lv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
