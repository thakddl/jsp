package trainerList.dao;

import java.util.List;

import exercise.vo.ExerciseVO;
import member.vo.MemberVO;
import membership.vo.MembershipVO;
import subscribe.vo.SubscribeVO;
import trainerList.vo.TrainerVO;

public interface ItrainerListDao {
	
	 public TrainerVO getMembershipCnt(String trainerId);
	 
	 public TrainerVO getSubscribeCnt(String trainerId);
	 
	 public TrainerVO getNickNm(String trainerId);
	 
	 public TrainerVO getExcsNm(String trainerId);
	 
	 public List<String> getAllTrainerId();
}
