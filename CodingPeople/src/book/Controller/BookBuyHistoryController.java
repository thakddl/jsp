package book.Controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Service.BookServiceImpl;
import book.Service.IBookService;
import book.VO.BbuyHistoryVO;
import book.VO.BookCategoryVO;
import book.VO.BookVO;
import coin.service.CoinServiceImpl;
import coin.service.IcoinService;
import coin.vo.CoinHistoryVO;
import coin.vo.MemberVO;

@WebServlet("/buyHistory.do")
public class BookBuyHistoryController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		String bookInfoId = req.getParameter("bookInfoId");
		String bookGradeId = req.getParameter("bookGrade");
		
		IBookService service = BookServiceImpl.getInstance();
		
		BookVO bv = new BookVO();
		bv.setBookinfoId(bookInfoId);
		bv.setBookGradeId(bookGradeId);
		
		BookVO bv2 = service.getSaleStock(bv);
		
		BbuyHistoryVO bbv = new BbuyHistoryVO();
		bbv.setMemId(memId);
		bbv.setBookinfoId(bookInfoId);
		bbv.setBookGradeId(bookGradeId);
		bbv.setBbHistoryPrice(bv2.getBookSale());
		
		System.out.println(bv2.getBookSale());
		
		IcoinService cService = CoinServiceImpl.getInstance();
		
		MemberVO mv = cService.getMember(memId);
		
		if(Integer.parseInt(mv.getMemCoin()) < Integer.parseInt(bv2.getBookSale())) {
			req.setAttribute("charge","abc");
			List<BookCategoryVO> categoryList = service.bookCategory();
			
			req.setAttribute("categoryList", categoryList);
			
			req.getRequestDispatcher("/bookbuy.jsp").forward(req, resp);
//			String redirectUrl = req.getContextPath() + "/book/bookSaleEnd.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
//			
//			resp.sendRedirect(redirectUrl);
			
		} else {
			
		IcoinService coinService = CoinServiceImpl.getInstance();
		MemberVO memVO = coinService.getMember(memId); //충전한 사람
		
		//충전기록VO 생성
		CoinHistoryVO cHistoryVO = new CoinHistoryVO();
		
		//충전기록값 설정
		cHistoryVO.setcHistoryNo(coinService.getChistroySeq());
		memVO = coinService.getMember(memId);
		cHistoryVO.setcHistoryBalance(memVO.getMemCoin());
		cHistoryVO.setcHistoryCoin("-" + bbv.getBbHistoryPrice());
		cHistoryVO.setMemId(memId);
		cHistoryVO.setcEventId("책 구매");
		
		int cnt = service.insertBuyHistory(bbv);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
			service.bookStock(bv);
			service.bookBuyCoin(bbv);
			coinService.insertCoinHistory(cHistoryVO);
		} else {
			msg = "실패";
		}
		
		
		String redirectUrl = req.getContextPath() + "/book/bookbuyend.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
		}
		
		
		
		
	}
	
}
