package trainerHome.dao;

import java.util.List;

import trainerHome.vo.TrainerHomeVO;

public interface ITrainerHomedao {
	
	//글 삽입
	public int insertTrainerHome(TrainerHomeVO tvo);
	
	//모든 트레이너의 홈 컨텐츠 내용
	public List<TrainerHomeVO> getAllTrainerMainList();
	
	//detail
	public TrainerHomeVO eachTrainerintro(String trainerId);
	
	//update
	public int updateTrainerHome(TrainerHomeVO tvo);
	
	//회원정보 조회
	public TrainerHomeVO getTrainer(String trainerId);
}
