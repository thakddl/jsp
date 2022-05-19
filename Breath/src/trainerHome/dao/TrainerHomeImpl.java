package trainerHome.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.SqlMapClientFactory;
import trainerHome.vo.TrainerHomeVO;

public class TrainerHomeImpl implements ITrainerHomedao {

	private static ITrainerHomedao trainerHomedao;
	
	private SqlMapClient smc;
	
	private TrainerHomeImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ITrainerHomedao getInstance() {
		if(trainerHomedao == null) {
			trainerHomedao = new TrainerHomeImpl();
		}
		return trainerHomedao;
	}
	
	@Override
	public int insertTrainerHome(TrainerHomeVO tvo) {
		
		int cnt = 0;
		
		try {
			cnt = smc.update("trainerHome.insertTrainerInfo", tvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<TrainerHomeVO> getAllTrainerMainList() {
		
		List<TrainerHomeVO> trainerInfo = new ArrayList<>();
		
		try {
			trainerInfo = smc.queryForList("trainerHome.getTrainerHomeALl");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return trainerInfo;
	}

	@Override
	public TrainerHomeVO eachTrainerintro(String trainerId) {
		
		TrainerHomeVO tvo = new TrainerHomeVO();
		
		try {
			tvo = (TrainerHomeVO) smc.queryForObject("trainerHome.eachTrainerInfo", trainerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tvo;
	}

	@Override
	public int updateTrainerHome(TrainerHomeVO tvo) {
		
		int cnt = 0;
		
		try {
			cnt = smc.update("trainerHome.updateTrainerInfo", tvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public TrainerHomeVO getTrainer(String trainerId) {
		
		TrainerHomeVO tvo = new TrainerHomeVO();
		
		try {
			tvo = (TrainerHomeVO) smc.queryForObject("trainerHome.getTrainer", trainerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tvo;
	}

	

}
