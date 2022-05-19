package membership.service;

import java.util.List;

import membership.dao.IMembershipDao;
import membership.dao.MembershipDaoImpl;
import membership.vo.MembershipVO;
import pay.vo.PayVO;

public class MembershipServiceImpl implements IMembershipService {

	private static IMembershipService service;
	private IMembershipDao dao;
	
	public MembershipServiceImpl() {
		dao = MembershipDaoImpl.getInstance();
	}

	public static IMembershipService getInstance() {
		if (service == null) {
			service = new MembershipServiceImpl();
		}
		return service;
	}
	

	@Override
	public int inserMembership(MembershipVO mv) {
		return dao.inserMembership(mv);
	}

	@Override
	public int updateAthrt(String memId) {
		return dao.updateAthrt(memId);
	}

	@Override
	public List<MembershipVO> getShipList(String memId) {
		return dao.getShipList(memId);
	}

	@Override
	public MembershipVO getShipDetail(String memId) {
		return dao.getShipDetail(memId);
	}

	@Override
	public int shipCount() {
		return dao.shipCount();
	}

}
