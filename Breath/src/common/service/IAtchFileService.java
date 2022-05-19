package common.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.vo.AtchFileVO;

public interface IAtchFileService {
	
	/**
	 * 첨부파일 목록을 저장하기 위한 메서드
	 * @param req Part객체를 꺼내기 위한 요청객체
	 * @return 저장한 첨부파일 정보
	 * @throws Exception
	 */
	public AtchFileVO saveAtchFileList(HttpServletRequest req) throws Exception;
	
	public AtchFileVO saveAtchFileList1(HttpServletRequest req) throws Exception;
	/**
	 * 첨부파일 목록 조회하기
	 * @param atchFileVO
	 * @return
	 * @throws SQLException
	 */
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO)
		throws SQLException;
	
	/**
	 * 첨부파일 세부목록을 조회하는 메서드
	 * @param atchFileVO 첨부파일 세부목록을 가져오기 위한 AtchFileVO객체  
	 * @return 첨부파일 세부목록이 담겨있는 리스트 객체
	 * @throws Exception
	 */
	public List<AtchFileVO> getAtchFileDetailList(AtchFileVO atchFileVO) throws Exception;

}
