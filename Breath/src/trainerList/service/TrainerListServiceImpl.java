package trainerList.service;

import java.util.List;

import exercise.vo.ExerciseVO;
import member.vo.MemberVO;
import membership.vo.MembershipVO;
import subscribe.vo.SubscribeVO;
import trainerList.dao.ItrainerListDao;
import trainerList.dao.TrainerListDaoImpl;
import trainerList.vo.TrainerVO;

public class TrainerListServiceImpl implements ITrainerListService {
	
	private static ITrainerListService trainerListService;
	
	private ItrainerListDao trainerDao;
	
	private TrainerListServiceImpl() {
		trainerDao = TrainerListDaoImpl.getInstance();
	}
	
	public static ITrainerListService getInstance() {
		if(trainerListService == null) {
			trainerListService = new TrainerListServiceImpl();
		}
		return trainerListService;
	}

	@Override
	public TrainerVO gettrainerVO(String trainerId) {
		TrainerVO vo = new TrainerVO();
		
		vo.setSubscribeCnt(trainerDao.getSubscribeCnt(trainerId).getSubscribeCnt());
		vo.setMembershipCnt(trainerDao.getMembershipCnt(trainerId).getMembershipCnt());
		vo.setTrainerNikNm(trainerDao.getNickNm(trainerId).getTrainerNikNm());
		vo.setExcsNm(trainerDao.getExcsNm(trainerId).getExcsNm());
		
		return vo;
	}

	@Override
	public List<String> getAllTrainerId() {
		
		return trainerDao.getAllTrainerId();
	}
	
	
}
