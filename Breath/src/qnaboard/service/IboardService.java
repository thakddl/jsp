package qnaboard.service;

import java.util.List;

import qnaboard.vo.qnaBoardVO;

public interface IboardService {
	public List<qnaBoardVO> getList();

	public qnaBoardVO getContent(String post_num);

	public int insertBoard(qnaBoardVO bv);
	
	public int updateBoard(qnaBoardVO bv);

	public int deleteMember(String post_num);

}
