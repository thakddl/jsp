package trainerVideo.dao;

import java.util.List;

import trainerVideo.vo.TrainerVideoVO;


public interface ITrainerVideoDao {
	/**
	 * TrainerVideoVO객체에 담겨진 자료를 insert하는 메서드
	 * @param lv insert할 자료가 저장된 TrainerVideoVO 객체
	 * @return 작업성공 : 1, 작업실패: 0 반환 
	 */
	public int insertVideo(TrainerVideoVO lv);
	
	/**
	 * TrainerVideoVO객체에 담겨진 자료를 update하는 메서드
	 * @param lv update할 자료가 저장된 TrainerVideoVO 객체
	 * @return 작업성공 : 1, 작업실패 : 0 반환
	 */
	public int updateVideo(TrainerVideoVO lv);
	
	/** TrainerVideoVO객체에 담겨진 자료를 delete하는 메서드
	 * @param lv delete할 자료가 저장된 TrainerVideoVO 객체
	 * @return 작업성공 : 1, 작업실패 : 0 반환
	 */
	public int deleteVideo(TrainerVideoVO lv);
	
	/**
	 * DB안의 TRAINER_VIDEO 테이블에서 trainerId가 작성한 게시물 전체 레코드를 담아 반환하는 메서드 
	 * @param TrainerVideoVO
	 * @return TrainerVideoVO객체를 담고있는 List객체
	 */
	public List<TrainerVideoVO> getAllVideoList(TrainerVideoVO lv);
}
