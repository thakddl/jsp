package membership.dao;

import java.util.List;

import membership.vo.MembershipVO;

public interface IMembershipDao {
	
	/**
	 * 멤버쉽 정보를 DB에 저장하기 위한 메소드
	 * @param pv 결제 정보가 담긴 객체
	 * @return 성공 : 1, 실패 : 0
	 */
	public int inserMembership(MembershipVO mv);
	
	/**
	 * 멤버쉽 등록 후 회원의 권한 업데이트
	 * @param memId 권한 업데이트가 필요한 회원ID
	 * @return 성공 : 1, 실패 : 0
	 */
	public int updateAthrt(String memId);
	
	/**
	 * 회원이 가입 중인 멤버쉽 리스트 리턴
	 * @param memId 멤버쉽 리스트 불러올 회원ID
	 * @return 성공 시 membership정보가 담긴 객체 리스트
	 */
	public List<MembershipVO> getShipList(String memId);
	
	/**
	 * 결제 내역을 포함한 멤버쉽 상세정보 리턴
	 * @param memId 
	 * @return
	 */
	public MembershipVO getShipDetail(String memId);
	
	/**
	 * 전체 멤버쉽 가입자를 조회하는 메서드
	 * @return 멤버쉽 가입자 수 반환
	 */
	public int shipCount(); 
}
