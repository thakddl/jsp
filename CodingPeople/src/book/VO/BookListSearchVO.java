package book.VO;
/**
 * 관리자 > 도서관리 클릭 시 도서 리스트 불러오는 VO
 * ## boovo 뷰 테이블 활용
 * @author HJE
 *
 */
public class BookListSearchVO {

	String categoryId  ; // 카테고리아이디
	String bookinfoNm  ; // 책이름
	String bookGradeId ; // 도서상태
	String bookStock   ; // 도서재고(수량)
	String bookSale    ; // 도서판매가
	String bookCost    ; // 도서매입가
	String bookPrice   ; // 도서정가
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getBookinfoNm() {
		return bookinfoNm;
	}
	public void setBookinfoNm(String bookinfoNm) {
		this.bookinfoNm = bookinfoNm;
	}
	public String getBookGradeId() {
		return bookGradeId;
	}
	public void setBookGradeId(String bookGradeId) {
		this.bookGradeId = bookGradeId;
	}
	public String getBookStock() {
		return bookStock;
	}
	public void setBookStock(String bookStock) {
		this.bookStock = bookStock;
	}
	public String getBookSale() {
		return bookSale;
	}
	public void setBookSale(String bookSale) {
		this.bookSale = bookSale;
	}
	public String getBookCost() {
		return bookCost;
	}
	public void setBookCost(String bookCost) {
		this.bookCost = bookCost;
	}
	public String getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	

}
