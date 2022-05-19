package GroupStudy.Service;

import java.util.List;

import GroupStudy.DAO.GroupStudyDAOImpl;
import GroupStudy.DAO.IGroupStudyDAO;
import GroupStudy.VO.GroupStudyVO;
import GroupStudy.VO.JoinVO;
import GroupStudy.VO.SMemberVO;

public class GroupStudyServiceImpl implements IGroupStudyService{

	private static IGroupStudyService groupStudyService;
	private IGroupStudyDAO groupStudyDAO;
	
	private GroupStudyServiceImpl() {
		groupStudyDAO = GroupStudyDAOImpl.getInstance();
	}
	
	public static IGroupStudyService getInstance() {
		if (groupStudyService == null) {
			groupStudyService = new GroupStudyServiceImpl();
		}
		
		return groupStudyService;
	}
	
	
	@Override
	public List<JoinVO> getGroupStudyInfo() {
		return groupStudyDAO.getGroupStudyInfo();
	}

	@Override
	public List<GroupStudyVO> getGroupStudyList() {
		return groupStudyDAO.getGroupStudyList();
	}
	
	@Override
	public int createGroupStudy(GroupStudyVO gsv) {
		return groupStudyDAO.createGroupStudy(gsv);
	}

	@Override
	public List<SMemberVO> getMemberList(String memId) {
		return groupStudyDAO.getMemberList(memId);
	}

	@Override
	public GroupStudyVO getGroupStudyDetailInfo(String memId) {
		return groupStudyDAO.getGroupStudyDetailInfo(memId);
	}

	@Override
	public int joinGroupStudy(SMemberVO sMemberVO) {
		return groupStudyDAO.joinGroupStudy(sMemberVO);
	}

	@Override
	public List<JoinVO> myGroupStudyDetailInfo(String memId) {
		return groupStudyDAO.myGroupStudyDetailInfo(memId);
	}

	@Override
	public int smemberUpdate(SMemberVO sv) {
		return groupStudyDAO.smemberUpdate(sv);
	}

	@Override
	public int smemberDelete(SMemberVO sv) {
		return groupStudyDAO.smemberDelete(sv);
	}




	
	
	
}
