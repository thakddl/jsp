package qnaboard.dao;

import java.util.List;

import qnaboard.vo.qnaBoardVO;

public interface IBoardDAO {

	List<qnaBoardVO> selectList();

	qnaBoardVO getContent(String post_num);

	int insertBoard(qnaBoardVO bv);

	int updateBoard(qnaBoardVO bv);

	int deleteBoard(String post_num);

}
