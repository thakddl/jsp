package admin.service;

import java.util.List;

import admin.dao.AdminDaoImpl;
import admin.dao.IAdminDao;
import admin.vo.AdminVO;
import admin.vo.ReportVO;

public class AdminServiceImpl implements IAdminService {

	private static IAdminService service;
	private IAdminDao dao;
	
	public AdminServiceImpl() {
		dao = AdminDaoImpl.getInstance();
	}

	public static IAdminService getInstance() {
		if (service == null) {
			service = new AdminServiceImpl();
		}
		return service;
	}
	
	@Override
	public int checkAdmin(AdminVO adVO) {
		return dao.checkAdmin(adVO);
	}

	@Override
	public List<AdminVO> getMemAll() {
		return dao.getMemAll();
	}

	@Override
	public int memCount() {
		return dao.memCount();
	}

	@Override
	public AdminVO getMember(String memId) {
		return dao.getMember(memId);
	}

	@Override
	public int updateMember(AdminVO adVO) {
		return dao.updateMember(adVO);
	}

	
	
	
	
	/*                    신고 관리                     */
	
	@Override
	public List<ReportVO> getAllreport() {
		return dao.getAllreport();
	}
	
	
	
	
	
	
	/*                  블랙리스트 관리                 */
	
	@Override
	public List<AdminVO> getBlackList() {
		return dao.getBlackList();
	}

	@Override
	public int memToBlack(String memId) {
		return dao.memToBlack(memId);
	}

	@Override
	public int BlackToMem(String memId) {
		return dao.BlackToMem(memId);
	}

	@Override
	public int blackCount() {
		return dao.blackCount();
	}
	
	




	
	
}
