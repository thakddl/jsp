package common.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.AtchFileVO;
import util.SqlMapClientFactory;

public class AtchFileDaoImpl implements IAtchFileDao{
	// 필드 선언
	public static IAtchFileDao atchFileDao;
	private SqlMapClient smc;
	
	// 생성자 선언(싱글톤)
	private AtchFileDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IAtchFileDao getInstance() {
		if (atchFileDao == null) {
			atchFileDao = new AtchFileDaoImpl();
		}
		return atchFileDao;
	}
	
	@Override
	public int insertAtchFile(AtchFileVO atchFileVO) throws SQLException {
		int cnt = 0 ;
		
		Object obj =  smc.insert("atchFile.insertAtchFile", atchFileVO);
		if (obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public List<AtchFileVO> getAtchFileDetailList(AtchFileVO atchFileVO) throws SQLException {
		List<AtchFileVO> fv = smc.queryForList("atchFile.getAtchFileDetailList", atchFileVO);
		return fv;
	}

	@Override
	public int insertAtchFileDetail(AtchFileVO atchFileVO) throws SQLException {
		int cnt = 0;
		
		Object obj =  smc.insert("atchFile.insertAtchFileDetail", atchFileVO);
		
		if (obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO) throws SQLException {
		List<AtchFileVO> atchFileList = smc.queryForList("atchFile.getAtchFileList", atchFileVO);
		
		return atchFileList;
	}

	
	
}
