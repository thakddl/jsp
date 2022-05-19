package adminCategory.vo;

// 관리자 전체 카테고리 VO
public class AdminCategoryVO {
	String categoryId;     //카테고리아이디
	String categoryName;   //카테고리명
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
