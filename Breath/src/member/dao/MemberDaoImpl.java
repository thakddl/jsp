package member.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import member.vo.MemberVO;
import util.SqlMapClientFactory;

public class MemberDaoImpl implements IMemberDao {
	
	private static IMemberDao memDao;
	
	private SqlMapClient smc;
	
	private MemberDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IMemberDao getInstance() {
		if (memDao == null) {
			memDao = new MemberDaoImpl();
		}
		return memDao;
	}
	
	@Override
	public boolean checkMember(String memId) {
	
		boolean isExist = false;
		
		try {
			int cnt = (int) smc.queryForObject("member.checkMember", memId);
			
			if (cnt > 0) {
				isExist = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isExist;
		
	}
	
	@Override
	public int insertMember(MemberVO mv) {
		int cnt = 0;
		try {
			cnt = smc.update("signupMember.insertMember", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;
		try {
			cnt = smc.update("signupMember.updateMember", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int updatePass(MemberVO mv) {
		int cnt = 0;
		try {
			cnt =  smc.update("signupMember.updatePass", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		
		int cnt = 0;
		try {
			cnt = smc.update("signupMember.deleteMember", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			memList = smc.queryForList("member.getMemberAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return memList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		
		List<MemberVO> memList = new ArrayList<>();
		
		try {
			memList = smc.queryForList("member.searchMember", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memList;
	}

	@Override
	public MemberVO getMember(MemberVO mv) {
		MemberVO vo = new MemberVO();
		try {
			vo = (MemberVO) smc.queryForObject("signupMember.getMember", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

}
