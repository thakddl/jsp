package adminMember.dao;

import java.util.List;

import adminMember.vo.AllMembershipInfoVO;

public interface IAdminMemDAO {

	/**
	 * 전체 회원 조회
	 * @return - 전체 회원정보 리턴
	 */
	public List<AllMembershipInfoVO> selectAllMember();
	
	
	/**
	 * 회원정보 수정
	 * @param memInfoVo - 전체 회원정보 vo
	 * @return
	 */
	public int updateMember(AllMembershipInfoVO memInfoVo);
	
	
	/**
	 * 회원정보 불러오기
	 * @param memId - 회원 아이디
	 * @return - 회원 아이디로 조회된 해당 회원의 회원정보
	 */
	public AllMembershipInfoVO getMember(String memId);

	
	/**
	 * 검색기능 - 검색란에 입력된 키워드가 포함된 데이터 조회
	 * @param keyword - 검색 창에 입력되는 키워드
	 * @return - 키워드를 포함하고 있는 회원 데이터
	 */
	public List<AllMembershipInfoVO> searchMember(String keyword);

}
