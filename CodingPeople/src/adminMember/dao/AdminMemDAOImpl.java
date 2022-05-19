package adminMember.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import Util.SqlMapClientFactory;
import adminMember.vo.AllMembershipInfoVO;

public class AdminMemDAOImpl implements IAdminMemDAO {
	
	// 싱글톤 만들기
	private static IAdminMemDAO adminMemDao;
	private SqlMapClient smc;
	private AdminMemDAOImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	public static IAdminMemDAO getInstance() {
		if(adminMemDao==null) {
			adminMemDao=new AdminMemDAOImpl();
		}
		return adminMemDao;
	}

	@Override
	// 전체 회원 조회
	public List<AllMembershipInfoVO> selectAllMember() {
		List<AllMembershipInfoVO> memList = new ArrayList<AllMembershipInfoVO>();
		
		try {
			memList=smc.queryForList("adminMem.selectAllMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	} // selectAllMember() end
	
	
	@Override
	// 회원정보 수정
	public int updateMember(AllMembershipInfoVO memInfoVo) {
		int cnt = 0;
		
		try {
			cnt = smc.update("adminMem.updateMember",memInfoVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	} // updateMember() end
	
	
	
	@Override
	// 아이디로 검색된 회원정보 불러오기
	public AllMembershipInfoVO getMember(String memId) {
		AllMembershipInfoVO getMemVo = new AllMembershipInfoVO();

		try {
			getMemVo = (AllMembershipInfoVO) smc.queryForObject("adminMem.getMember",memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getMemVo;
	} // getMember() end
	
	
	@Override
	// 검색 키워드에 해당되는 회원정보 불러오기
	public List<AllMembershipInfoVO> searchMember(String keyword) {
		List<AllMembershipInfoVO> srchMemList = new ArrayList<>();
		try {
			srchMemList = smc.queryForList("adminMem.searchMember",keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return srchMemList;
	} // searchMember() 끝
	
}
