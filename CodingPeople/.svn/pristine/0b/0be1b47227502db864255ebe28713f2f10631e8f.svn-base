package GroupStudy.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import GroupStudy.VO.GroupStudyVO;
import GroupStudy.VO.JoinVO;
import GroupStudy.VO.SMemberVO;
import Util.SqlMapClientFactory;

public class GroupStudyDAOImpl implements IGroupStudyDAO{

	private static IGroupStudyDAO groupStudyDAO;
	private SqlMapClient smc;
	
	private GroupStudyDAOImpl() {
		smc = SqlMapClientFactory.getInstance();
	}

	public static IGroupStudyDAO getInstance() {
		if (groupStudyDAO == null) {
			groupStudyDAO = new GroupStudyDAOImpl();
		}
		return groupStudyDAO;
	}
	
	
	@Override
	public List<JoinVO> getGroupStudyInfo() {
		List<JoinVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("groupStudy.getGroupStudyDetailInfo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<GroupStudyVO> getGroupStudyList() {
		List<GroupStudyVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("groupStudy.getGroupStudylist");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int createGroupStudy(GroupStudyVO gsv) {
		int cnt = 0;
		
		try {
			// groupStudy테이블에 데이터 insert
			cnt = smc.update("groupStudy.createGroupStudy",gsv);
			
			// 그룹스터디원테이블에 데이터 insert
			smc.update("groupStudy.setStudyMember",gsv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<SMemberVO> getMemberList(String memId) {
		List<SMemberVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("groupStudy.getMemberList",memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public GroupStudyVO getGroupStudyDetailInfo(String memId) {
		GroupStudyVO gsv = new GroupStudyVO();
		
		try {
			gsv = (GroupStudyVO) smc.queryForObject("groupStudy.getGroupStudyDetailInfo2",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return gsv;
	}

	@Override
	public int joinGroupStudy(SMemberVO sMemberVO) {
		
		int cnt = 0;
		
		try {
			cnt = smc.update("groupStudy.joinGroupStudy",sMemberVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<JoinVO> myGroupStudyDetailInfo(String memId) {
		
		List<JoinVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("groupStudy.myGroupStudyDetailInfo",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int smemberUpdate(SMemberVO sv) {
		
		int cnt = 0;
		
		try {
			cnt = smc.update("groupStudy.smemberUpdate",sv);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int smemberDelete(SMemberVO sv) {
		
		int cnt = 0;
	
		try {
			cnt = smc.delete("groupStudy.smemberDelete",sv);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return cnt;
	}
}
