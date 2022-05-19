package report.service;

import java.sql.SQLException;

import report.dao.IReportDao;
import report.dao.ReportDaoImpl;
import report.vo.ReportVO;

public class ReportServiceImpl implements IReportService{
	private static IReportService reportService;
	private IReportDao reportDao;
	
	private ReportServiceImpl() {
		reportDao = ReportDaoImpl.getInstance();
	}
	
	public static IReportService getInstance() {
		if (reportService == null) {
			reportService = new ReportServiceImpl();
		}
		return reportService;
	}

	@Override
	public int insertReport(ReportVO rv) throws SQLException {
		return reportDao.insertReport(rv);
	}

	@Override
	public int updateReportStatus(int rprtStatus) {
		return reportDao.updateReportStatus(rprtStatus);
	}

	@Override
	public int reportCount() {
		return reportDao.reportCount();
	}

}
