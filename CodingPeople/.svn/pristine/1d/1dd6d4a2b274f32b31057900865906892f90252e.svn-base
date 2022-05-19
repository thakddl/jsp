package adminMember.service;

import java.util.List;

import adminMember.vo.AllMembershipInfoVO;

public interface IAdminMemService {
	// 회원 전체를 조회
	public List<AllMembershipInfoVO> selectAllMember();
	
	// 회원정보 수정
	public int updateMember(AllMembershipInfoVO memInfoVo);
	
	// 아이디로 검색된 회원정보 불러오기
	public AllMembershipInfoVO getMember(String memId);

	// 키워드 포함된 결과 검색기능
	public List<AllMembershipInfoVO> searchMember(String keyword);

}
