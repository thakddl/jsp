package report.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import report.vo.ReportVO;
import util.SqlMapClientFactory;

public class ReportDaoImpl implements IReportDao{
	private static IReportDao reportDao;
	SqlMapClient smc;
	
	private ReportDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IReportDao getInstance() {
		if (reportDao == null) {
			reportDao = new ReportDaoImpl();
		} 
		return reportDao;
	}
	
	@Override
	public int insertReport(ReportVO rv) throws SQLException {
		int cnt = 0;
		smc.insert("report.insertReport", rv);
		return cnt;
	}

	@Override
	public int updateReportStatus(int rprtStatus) {
		int cnt = 0;
		try {
			smc.update("report.updateReportStatus", rprtStatus);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int reportCount() {
		int cnt = 0;
		
		try {
			cnt = (int)smc.queryForObject("report.reportCount");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

}
