package book.Service;

import java.util.List;

import book.DAO.BookDAOImpl;
import book.DAO.IBookDAO;
import book.VO.BbuyHistoryVO;
import book.VO.BookCategoryVO;
import book.VO.BookInfoVO;
import book.VO.BookListSearchVO;
import book.VO.BookVO;
import book.VO.BsellHistoryVO;

public class BookServiceImpl implements IBookService{
	
	private static IBookService bookService;
	private IBookDAO bookDAO;
	
	private BookServiceImpl() {
		bookDAO = BookDAOImpl.getInstance();
	}
	
	public static IBookService getInstance() {
		if(bookService == null) {
			bookService = new BookServiceImpl();
		}
		
		return bookService;
    }

	@Override
	public List<BookCategoryVO> displayCategory() {
		return bookDAO.displayCategory();
	}

	@Override
	public List<BookInfoVO> getBookInfoNm(String categoryId) {
		return bookDAO.getBookInfoNm(categoryId);
	}

	@Override
	public int insertHistory(BsellHistoryVO bsv) {
		return bookDAO.insertHistory(bsv);
	}

	@Override
	public List<BookCategoryVO> bookCategory() {
		return bookDAO.bookCategory();
	}

	@Override
	public List<BookInfoVO> getInfoNm(String categoryId) {
		return bookDAO.getInfoNm(categoryId);
	}

	@Override
	public List<BookVO> getBookGrade(String bookInfoId) {
		return bookDAO.getBookGrade(bookInfoId);
	}

	@Override
	public List<BookVO> bookCategory(BookVO bv) {
		return bookDAO.bookCategory(bv);
	}

	@Override
	public BookVO getSaleStock(BookVO bv) {
		return bookDAO.getSaleStock(bv);
	}

	@Override
	public int insertBuyHistory(BbuyHistoryVO bbv) {
		return bookDAO.insertBuyHistory(bbv);
	}

	@Override
	public List<BookListSearchVO> getAdminBookList() {
		return bookDAO.getAdminBookList();
	}

	@Override
	public int bookStock(BookVO bv) {
		return bookDAO.bookStock(bv);
	}

	@Override
	public int bookBuyCoin(BbuyHistoryVO bbv) {
		return bookDAO.bookBuyCoin(bbv);
	}

	
	
	
	
	
	
}
	
