package GroupStudy.Service;

import java.util.List;

import GroupStudy.VO.GroupStudyVO;
import GroupStudy.VO.JoinVO;
import GroupStudy.VO.SMemberVO;

public interface IGroupStudyService {

	public List<JoinVO> getGroupStudyInfo();
	
	public List<GroupStudyVO> getGroupStudyList();
	
	public int createGroupStudy(GroupStudyVO gsv);
	
	public List<SMemberVO> getMemberList(String memId);
	
	public GroupStudyVO getGroupStudyDetailInfo(String memId);
	
	public List<JoinVO> myGroupStudyDetailInfo(String memId);
	
	public int joinGroupStudy(SMemberVO sMemberVO);
	
	public int smemberUpdate(SMemberVO sv);
	
	public int smemberDelete(SMemberVO sv);
}
