package adminCategory.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import Util.SqlMapClientFactory;
import adminCategory.vo.AdminCategoryVO;
import adminMember.vo.AllMembershipInfoVO;

public class AdminCategoryDaoImpl implements IAdminCategoryDao{
	// 멤버변수 선언
	private static IAdminCategoryDao adminCategoryDao;
	
	private SqlMapClient smc;
	
	// 생성자
	private AdminCategoryDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IAdminCategoryDao getInstance() {
		if(adminCategoryDao==null) {
			adminCategoryDao=new AdminCategoryDaoImpl();
		}
		return adminCategoryDao;
	}
	
	
	@Override
	/**
	 * 모든 카테고리를 조회하는 메서드
	 */
	public List<AdminCategoryVO> selectAllCategory() {
		List<AdminCategoryVO> categoryList = new ArrayList<AdminCategoryVO>();
		try {
			categoryList = smc.queryForList("adminCategory.selectAllCategory");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}

	@Override
	/**
	 * 회원정보 수정
	 */
	public int updateCategory(AdminCategoryVO ctgrInfoVo) {
		int cnt = 0;
		
		try {
			cnt=smc.update("adminCategory.updateCategory",ctgrInfoVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	
	@Override
	// 카테고리 아이디로 카테고리 정보 불러오기
	public AdminCategoryVO getCategory(String ctgrId) {
		AdminCategoryVO getCtgrVo = new AdminCategoryVO();
		try {
			getCtgrVo=(AdminCategoryVO) smc.queryForObject("adminCategory.getCategory",ctgrId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getCtgrVo;
	}

	@Override
	// 카테고리 검색 
	public List<AdminCategoryVO> searchCategory(String keyword) {
		List<AdminCategoryVO> srchCtgrList = new ArrayList<>();
		try {
			srchCtgrList = smc.queryForList("adminCategory.searchCategory",keyword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return srchCtgrList;
	}

	@Override
	// 신규 카테고리 추가
	public int insertCategory(AdminCategoryVO ctgrInfoVo) {
		int cnt = 0;
		
			try {
				cnt=smc.update("adminCategory.insertCategory",ctgrInfoVo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return cnt;
	}

	@Override
	public int deleteCategory(String ctgrId) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("adminCategory.deleteCategory",ctgrId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

}
