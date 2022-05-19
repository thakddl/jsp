package member.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import member.vo.JoinMemberVO;
import Util.SqlMapClientFactory;
import adminMember.vo.AllMembershipInfoVO;

public class JoinMemberDAOImpl implements IJoinMemberDAO{
	
	private static IJoinMemberDAO joinMemberDao;
	private SqlMapClient smc;
	private JoinMemberDAOImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	public static IJoinMemberDAO getInstance() {
		if(joinMemberDao==null) {
			joinMemberDao=new JoinMemberDAOImpl();
		}
		return joinMemberDao;
	}
	
	/**
	 * 회원가입
	 */
	@Override
	public int joinMember(JoinMemberVO vo) {
		int cnt = 0;
		try {
			cnt = smc.update("joinMem.joinMember",vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	/**
	 * 아이디 중복체크 메서드
	 */
	@Override
	public boolean idCheck(String memId) {
		boolean isExist = false;
		try {
			int cnt = (Integer) smc.queryForObject("joinMem.idCheck",memId);
			
			if(cnt>0) {
				isExist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isExist;
	}
	
	/**
	 *  회원세부정보 가져오기
	 */
	@Override
	public AllMembershipInfoVO getMember(String memId) {
		AllMembershipInfoVO MemVO = new AllMembershipInfoVO();
		
		try {
			MemVO = (AllMembershipInfoVO) smc.queryForObject("adminMem.getMember",memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MemVO;
	}
	
	@Override
	public int secessionMember(String memId) {
		
		int cnt = 0;
		
		try {
			cnt = smc.update("joinMem.secessionMember",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
}
