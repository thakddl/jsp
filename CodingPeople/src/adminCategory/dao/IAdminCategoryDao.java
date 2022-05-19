package adminCategory.dao;

import java.util.List;

import adminCategory.vo.AdminCategoryVO;
import adminMember.vo.AllMembershipInfoVO;

public interface IAdminCategoryDao {

	// 전체 카테고리 리스트 불러오기
	public List<AdminCategoryVO> selectAllCategory();
	
	
	// 카테고리 수정
	public int updateCategory(AdminCategoryVO ctgrInfoVo);
	
	
	// 카테고리 아이디로 카테고리 검색하기(카테고리 수정 시 사용)
	public AdminCategoryVO getCategory(String ctgrId);
	
	
	// 검색 키워드에 해당하는 카테고리 정보 불러오기
	public List<AdminCategoryVO> searchCategory(String keyword);
	
	// 신규 카테고리 추가하기
	public int insertCategory(AdminCategoryVO ctgrInfoVo);
	
	// 카테고리 삭제
	public int deleteCategory(String ctgrId);
}
