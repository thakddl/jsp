package adminMember.service;

import java.util.List;

import adminMember.dao.AdminMemDAOImpl;
import adminMember.dao.IAdminMemDAO;
import adminMember.vo.AllMembershipInfoVO;

// 회원관리 서비스
public class AdminMemServiceImpl implements IAdminMemService{

	private static IAdminMemService adminMemService;

	public static IAdminMemService getInstance() {
		if(adminMemService==null) {
			adminMemService = new AdminMemServiceImpl();
		}
		return adminMemService;
	}

	private IAdminMemDAO adminMemDao;
	
	private AdminMemServiceImpl() {
		adminMemDao = AdminMemDAOImpl.getInstance();
	}
	

	@Override
	// 모든 회원 조회 메서드
	public List<AllMembershipInfoVO> selectAllMember() {
		return adminMemDao.selectAllMember();
	}


	@Override
	// 회원정보 수정
	public int updateMember(AllMembershipInfoVO memInfoVo) {
		return adminMemDao.updateMember(memInfoVo);
	}


	@Override
	public AllMembershipInfoVO getMember(String memId) {
		return adminMemDao.getMember(memId);
	}


	@Override
	public List<AllMembershipInfoVO> searchMember(String keyword) {
		return adminMemDao.searchMember(keyword);
	}


	
}
