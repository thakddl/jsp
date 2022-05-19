package common.dao;

import java.sql.SQLException;
import java.util.List;

import common.vo.AtchFileVO;

public interface IAtchFileDao {
	
	/**
	 * 첨부파일을 넣는 메서드
	 * @param atchFileVO
	 * @return 작업 성공 : 1, 작업실패 : 0
	 * @throws SQLException
	 */
	public int insertAtchFile(AtchFileVO atchFileVO) throws SQLException;
	
	/**
	 * 첨부파일 세부정보를 넣는 메서드
	 * @param atchFileVO
	 * @return 작업성공 : 1, 작업실패 : 0
	 * @throws SQLException
	 */
	public int insertAtchFileDetail(AtchFileVO atchFileVO) throws SQLException;
	
	public List<AtchFileVO> getAtchFileDetailList(AtchFileVO atchFileVO) throws SQLException;
	/**
	 * 첨부파일 목록조회
	 * @param atchFileVO
	 * @return
	 * @throws SQLException
	 */
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO)
			throws SQLException;
	
	
}

