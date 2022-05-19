package member.service;


import adminMember.vo.AllMembershipInfoVO;
import member.dao.IJoinMemberDAO;
import member.dao.JoinMemberDAOImpl;
import member.vo.JoinMemberVO;

public class JoinMemberServiceImpl implements IJoinMemberService{

	private static IJoinMemberService joinMemberService;
	public static IJoinMemberService getInstance() {
		if(joinMemberService==null) {
			joinMemberService=new JoinMemberServiceImpl();
		}
		return joinMemberService;
	}
	private IJoinMemberDAO joinMemberDao;
	
	private JoinMemberServiceImpl() {
		joinMemberDao = JoinMemberDAOImpl.getInstance();
	}
	
	
	@Override
	// 회원가입
	public int joinMember(JoinMemberVO vo) {
		return joinMemberDao.joinMember(vo);
	}


	@Override
	// 아이디 중복체크
	public boolean idCheck(String memId) {
		return joinMemberDao.idCheck(memId);
	}


	@Override
	public AllMembershipInfoVO getMember(String memId) {
		return joinMemberDao.getMember(memId);
	}


	@Override
	public int secessionMember(String memId) {
		return joinMemberDao.secessionMember(memId);
	}

}
