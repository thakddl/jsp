package admin.dao;

import java.sql.SQLException;
import java.util.List;

import admin.vo.AdminVO;
import admin.vo.ReportVO;

public interface IAdminDao {
	
	/**
	 * 관리자 로그인을 위한 체크 메소드
	 * @param adVO ID, pasword, 권한코드를 담은 VO객체
	 * @return 성공 => 1, 실패 => 0  
	 * @throws SQLException
	 */
	public int checkAdmin(AdminVO av);
	
	/**
	 * 회원관리를 위한 회원리스트를 모두 불러오는 메소드
	 * @return 성공 시 모든 회원 리스트를 담은 VO 객체 반환
	 * @throws SQLException
	 */
	public List<AdminVO> getMemAll();
	
	/**
	 * 현재 전체 회원 수를 조회 하는 메소드
	 * @return 성공 시 모든 회원의 수를 int로 반환
	 */
	public int memCount(); 
	
	/**
	 * 주어진 회원ID로 회원정보를 알아내기 위한 메서드
	 * @param memId 검색할 회원 ID
	 * @return 해당회원 ID가 있으면 회원정보 리턴함
	 */
	public AdminVO getMember(String memId);
	
	/**
	 * MemberVO 객체를 매개변수로 받아 DB를 update하는 메서드
	 * @param adVO update할 회원 정보가 담긴 AdminVO객체
	 * @return 성공 : 1, 실패 : 0
	 */
	public int updateMember(AdminVO av);
	
	
	
	
	/*                  신고 관리                 */
	
	
	/**
	 * 신고 목록을 모두 불러오는 메소드
	 * @return 성공 시 신고 목록이 담긴 VO객체 반환
	 */
	public List<ReportVO> getAllreport();
	
	
	
	
	
	/*                  블랙리스트 관리                 */
	
	/**
	 * 블랙리스트 회원 목록을 불러오는 메소드
	 * @return 성공 시 모든 블랙리스트를 담은 VO 객체 반환
	 */
	public List<AdminVO> getBlackList();
	
	/**
	 * 일반 회원을 블랙 회원으로 상태코드를 변경하는 메소드
	 * @param memId 상태코드를 바꿀 회원의 ID
	 * @return 성공 : 1, 실패 0  반환.
	 */
	public int memToBlack(String memId);
	
	/**
	 * 블랙 회원을 일반 회원으로 상태코드를 변경하는 메소드
	 * @param memId 상태코드를 바꿀 회원의 ID
	 * @return 성공 : 1, 실패 0  반환.
	 */
	public int BlackToMem(String memId);
	
	/**
	 * 전체 블랙회원 수를 조회하기 위한 메서드
	 * @return 블랙회원 수 카운트 반환
	 */
	public int blackCount();
	
}
