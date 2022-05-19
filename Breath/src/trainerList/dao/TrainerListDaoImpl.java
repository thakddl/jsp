package trainerList.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import exercise.vo.ExerciseVO;
import util.SqlMapClientFactory;
import member.vo.MemberVO;
import membership.vo.MembershipVO;
import subscribe.vo.SubscribeVO;
import trainerList.vo.TrainerVO;

public class TrainerListDaoImpl implements ItrainerListDao{
	
	private static ItrainerListDao trainerDao;
	
	private SqlMapClient smc;
	
	private TrainerListDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ItrainerListDao getInstance() {
		if(trainerDao == null) {
			trainerDao = new TrainerListDaoImpl();
		}
		return trainerDao;
	}

	@Override
	public TrainerVO getMembershipCnt(String trainerId) {

		TrainerVO tvo = new TrainerVO();
		
		try {	
			String trainer = (String) smc.queryForObject("trainerList.getMembershipCnt", trainerId);
			tvo.setMembershipCnt(trainer); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tvo;
	}

	@Override
	public TrainerVO getSubscribeCnt(String trainerId) {
			
			TrainerVO tvo = new TrainerVO();
		try {
			String trainer = (String) smc.queryForObject("trainerList.getSubscribeCnt", trainerId);
			tvo.setSubscribeCnt(trainer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tvo;
	}

	@Override
	public TrainerVO getNickNm(String trainerId) {
		
		TrainerVO tvo = new TrainerVO();
		
		try {
			String trainer = (String) smc.queryForObject("trainerList.getTrainerNickNm", trainerId);
			tvo.setTrainerNikNm(trainer);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tvo;
	}

	@Override
	public TrainerVO getExcsNm(String trainerId) {
		
		TrainerVO tvo = new TrainerVO();
		try {
			String trainer = (String) smc.queryForObject("trainerList.getExerciseName", trainerId);
			tvo.setExcsNm(trainer);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tvo;
	}

	@Override
	public List<String> getAllTrainerId() {
		
		List<String> list = null;
		
		try {
		  	list = smc.queryForList("trainerList.getAllTrainerId");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
