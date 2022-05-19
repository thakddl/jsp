package qnaboard.service;

import java.util.List;

import qnaboard.dao.BoardDAOImpl;
import qnaboard.dao.IBoardDAO;
import qnaboard.vo.qnaBoardVO;

public class BoardServiceImpl implements IboardService {
	public static IboardService service;
	private IBoardDAO dao;
	
	private BoardServiceImpl() {
		dao = BoardDAOImpl.getInstance();
	}
	
	public static IboardService getInstance() {
		if (service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	@Override
	public List<qnaBoardVO> getList() {
		List<qnaBoardVO> boardList = dao.selectList();
		
		return boardList;
	}
	@Override
	public qnaBoardVO getContent(String post_num) {
		return dao.getContent(post_num);
	}

	@Override
	public int insertBoard(qnaBoardVO brv) {
		return dao.insertBoard(brv);
	}

	@Override
	public int updateBoard(qnaBoardVO brv) {
		return dao.updateBoard(brv);
	}

	@Override
	public int deleteMember(String post_num) {
		return dao.deleteBoard(post_num);
	}


	
}
