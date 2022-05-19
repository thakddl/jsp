package trainerList.service;


import java.util.List;

import exercise.vo.ExerciseVO;
import member.vo.MemberVO;
import membership.vo.MembershipVO;
import subscribe.vo.SubscribeVO;
import trainerList.vo.TrainerVO;

public interface ITrainerListService {
	
	public TrainerVO gettrainerVO(String trainerId);
	
	public List<String> getAllTrainerId();
}
