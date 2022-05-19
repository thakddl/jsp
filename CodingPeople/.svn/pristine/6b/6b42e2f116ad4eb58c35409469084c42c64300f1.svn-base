package book.DAO;

import java.util.List;

import book.VO.BbuyHistoryVO;
import book.VO.BookCategoryVO;
import book.VO.BookInfoVO;
import book.VO.BookListSearchVO;
import book.VO.BookVO;
import book.VO.BsellHistoryVO;

public interface IBookDAO {
	
	public List<BookCategoryVO> displayCategory();
	
	public List<BookCategoryVO> bookCategory();
	
	public List<BookInfoVO> getBookInfoNm(String categoryId);
	
	public List<BookInfoVO> getInfoNm(String categoryId);
	
	public List<BookVO> getBookGrade(String bookInfoId);
	
	public List<BookVO> bookCategory(BookVO bv);
	
	public BookVO getSaleStock(BookVO bv);

	public int insertHistory(BsellHistoryVO bsv);
	
	public int insertBuyHistory(BbuyHistoryVO bbv);
	
	public int bookStock(BookVO bv);
	
	public int bookBuyCoin(BbuyHistoryVO bbv);
	
	// 관리자 > 도서관리 리스트 조회 메서드 (HJE)
	public List<BookListSearchVO> getAdminBookList();
}
