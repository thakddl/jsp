package admin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import admin.vo.AdminVO;
import admin.vo.ReportVO;
import util.SqlMapClientFactory;

public class AdminDaoImpl implements IAdminDao {

	private SqlMapClient smc;
	
	private static IAdminDao dao;
	
	public AdminDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IAdminDao getInstance() {
		if (dao == null) {
			dao = new AdminDaoImpl();
		}
		return dao;
	}
	
	
	@Override
	public int checkAdmin(AdminVO av) {

		int cnt = 0;
		
		try {
			cnt =  (int) smc.queryForObject("admin.checkAdmin", av);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<AdminVO> getMemAll() {
		
		List<AdminVO> adminList = new ArrayList<AdminVO>();
		
		try {
			adminList = smc.queryForList("admin.memList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return adminList;
	}

	@Override
	public int memCount() {
		
		int cnt = 0;
		
		try {
			cnt = (int) smc.queryForObject("admin.memCount");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public AdminVO getMember(String memId) {
		
		AdminVO vo = new AdminVO();
		
		try {
			vo = (AdminVO) smc.queryForObject("admin.memDetail", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int updateMember(AdminVO av) {
		
		int cnt = 0;
		
		try {
			cnt = (int) smc.update("admin.updateMember", av);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	
	
	

	/*                    신고 관리                     */
	
	@Override
	public List<ReportVO> getAllreport() {
		
		List<ReportVO> ReVO = new ArrayList<>();
		
		try {
			ReVO = smc.queryForList("admin.reportList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ReVO;
	}
	
	
	
	
	
	
	/*                  블랙리스트 관리                 */
	
	@Override
	public List<AdminVO> getBlackList() {
		
		List<AdminVO> blackList = new ArrayList<AdminVO>();
		
		try {
			blackList = smc.queryForList("admin.blackList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return blackList;
	}

	@Override
	public int memToBlack(String memId) {
		
		int cnt = 0;
		
		try {
			cnt = (int) smc.update("admin.memToBlack", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int BlackToMem(String memId) {
		
		int cnt = 0;
		
		try {
			cnt = (int) smc.update("admin.blackToMem", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int blackCount() {
		
		int cnt = 0;
		
		try {
			cnt = (int) smc.queryForObject("admin.blackCount");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}


	




	

}
