package trainerHome.service;

import java.util.List;

import trainerHome.dao.ITrainerHomedao;
import trainerHome.dao.TrainerHomeImpl;
import trainerHome.vo.TrainerHomeVO;

public class TrainerHomeServiceImpl implements ITrainerHomeService {
	
	private static ITrainerHomeService trainerHomeService;
	
	private ITrainerHomedao trainerHomedao;
	
	private TrainerHomeServiceImpl() {
		trainerHomedao=TrainerHomeImpl.getInstance();
	}
	
	public static ITrainerHomeService getInstance() {
		if(trainerHomeService == null) {
			trainerHomeService = new TrainerHomeServiceImpl();
		}
		return trainerHomeService;
	}

	@Override
	public int insertTrainerHome(TrainerHomeVO tvo) {
		return trainerHomedao.insertTrainerHome(tvo);
	}

	@Override
	public List<TrainerHomeVO> getAllTrainerMainList() {
		return trainerHomedao.getAllTrainerMainList();
	}

	@Override
	public TrainerHomeVO eachTrainerintro(String trainerId) {
		return trainerHomedao.eachTrainerintro(trainerId);
	}

	@Override
	public int updateTrainerHome(TrainerHomeVO tvo) {
		return trainerHomedao.updateTrainerHome(tvo);
	}

	@Override
	public TrainerHomeVO getTrainer(String trainerId) {
		return trainerHomedao.getTrainer(trainerId);
	}

}
