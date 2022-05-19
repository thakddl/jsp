package report.service;

import java.sql.SQLException;

import report.vo.ReportVO;

public interface IReportService {
	/**
	 * 신고이력을 입력하는 메서드
	 * @param rv 신고한 회원Id, 신고받은 회원Id, 신고사유를 받는 ReportVO 객체
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int insertReport(ReportVO rv) throws SQLException;
	
	/**
	 * 신고 처리 후 해당 신고번호의 처리코드를 0으로 바꾸는 메서드
	 * @param rprtStatus 처리코드를 변경할 신고번호
	 * @return 성공 : 1, 실패 : 0
	 */
	public int updateReportStatus(int rprtStatus);
	
	/**
	 * 처리되지 않은 신고건수를 조회하는 메서드
	 * @return 성공 시 처리안된 신고 카운트 반환
	 */
	public int reportCount();
}
