package adminCategory.service;

import java.util.List;

import adminCategory.dao.AdminCategoryDaoImpl;
import adminCategory.dao.IAdminCategoryDao;
import adminCategory.vo.AdminCategoryVO;

public class AdminCategoryServiceImpl implements IAdminCategoryService{

	// 멤버변수 선언
	private static IAdminCategoryService adminCategoryService;
	private IAdminCategoryDao adminCategoryDao;
	
	public static IAdminCategoryService getInstance() {
		if(adminCategoryService==null) {
			adminCategoryService=new AdminCategoryServiceImpl();
		}
		return adminCategoryService;
	}
	
	private AdminCategoryServiceImpl() {
		
		adminCategoryDao = AdminCategoryDaoImpl.getInstance();
	}
	
	@Override
	public List<AdminCategoryVO> selectAllCategory() {
		return adminCategoryDao.selectAllCategory();
	}

	@Override
	public int updateCategory(AdminCategoryVO ctgrInfoVo) {
		return adminCategoryDao.updateCategory(ctgrInfoVo);
	}

	@Override
	public AdminCategoryVO getCategory(String ctgrId) {
		return adminCategoryDao.getCategory(ctgrId);
	}

	@Override
	public List<AdminCategoryVO> searchCategory(String keyword) {
		return adminCategoryDao.searchCategory(keyword);
	}

	@Override
	public int insertCategory(AdminCategoryVO ctgrInfoVo) {
		return adminCategoryDao.insertCategory(ctgrInfoVo);
	}

	@Override
	public int deleteCategory(String ctgrId) {
		return adminCategoryDao.deleteCategory(ctgrId);
	}
	
	
}
