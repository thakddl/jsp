package book.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import book.VO.BbuyHistoryVO;
import book.VO.BookCategoryVO;
import book.VO.BookInfoVO;
import book.VO.BookListSearchVO;
import book.VO.BookVO;
import book.VO.BsellHistoryVO;


public class BookDAOImpl implements IBookDAO{
	
	private static IBookDAO bookDAO;
	private SqlMapClient smc;
	
	private BookDAOImpl() {
		smc = Util.SqlMapClientFactory.getInstance();
	}
	
	public static IBookDAO getInstance() {
		if (bookDAO == null) {
			bookDAO = new BookDAOImpl();
		}
		return bookDAO;
	}

	@Override
	public List<BookCategoryVO> displayCategory() {
		
		List<BookCategoryVO> list = new ArrayList<BookCategoryVO>(); 
		
		try {
			list = smc.queryForList("book.displayCategory");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<BookInfoVO> getBookInfoNm(String categoryId) {
		
		List<BookInfoVO> list = new ArrayList<BookInfoVO>();
		
		try {
			list = smc.queryForList("book.getBookInfoNm",categoryId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insertHistory(BsellHistoryVO bsv) {
		int cnt = 0;
		
		try {
			cnt = smc.update("book.insertHistory",bsv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<BookCategoryVO> bookCategory() {
		
		List<BookCategoryVO> list = new ArrayList<BookCategoryVO>(); 
		
		try {
			list = smc.queryForList("book.bookCategory");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<BookInfoVO> getInfoNm(String categoryId) {
		
		List<BookInfoVO> list = new ArrayList<BookInfoVO>();
		
		try {
			list = smc.queryForList("book.getInfoNm",categoryId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<BookVO> getBookGrade(String bookInfoId) {

		List<BookVO> list = new ArrayList<BookVO>();
		
		try {
			list = smc.queryForList("book.getBookGrade",bookInfoId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<BookVO> bookCategory(BookVO bv) {

		List<BookVO> list = new ArrayList<BookVO>();
		
		try {
			list = smc.queryForList("book.bookCategory",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public BookVO getSaleStock(BookVO bv) {

		BookVO vo = new BookVO();
		try {
			vo = (BookVO) smc.queryForObject("book.getSaleStock",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int insertBuyHistory(BbuyHistoryVO bbv) {

		int cnt = 0;
		
		try {
			cnt = smc.update("book.insertBuyHistory",bbv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	/**
	 * 관리자 > 도서관리 도서리스트 불러오는 메서드 (HJE)
	 */
	public List<BookListSearchVO> getAdminBookList() {
		List<BookListSearchVO> adminBookList = new ArrayList<BookListSearchVO>();
		
		try {
			adminBookList = smc.queryForList("book.getAdminBookList");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminBookList;
	}

	@Override
	public int bookStock(BookVO bv) {
		
		int cnt = 0;
		
		try {
			cnt = smc.update("book.bookStock",bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int bookBuyCoin(BbuyHistoryVO bbv) {

		int cnt = 0;
		
		try {
			cnt = smc.update("book.bookBuyCoin",bbv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
}
