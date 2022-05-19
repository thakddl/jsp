package pay.sevice;

import pay.dao.IPayDao;
import pay.dao.PayDaoImpl;
import pay.vo.BuyerVO;
import pay.vo.PayVO;

public class PayServiceImpl implements IPayService {

	private static IPayService service;
	private IPayDao dao;
	
	public PayServiceImpl() {
		dao = PayDaoImpl.getInstance();
	}

	public static IPayService getInstance() {
		if (service == null) {
			service = new PayServiceImpl();
		}
		return service;
	}
	
	
	
	@Override
	public BuyerVO getBuyerInfo(String memId, String trainerId) {
		return dao.getBuyerInfo(memId, trainerId);
	}

	@Override
	public int inserPay(PayVO pv) {
		return dao.inserPay(pv);
	}

}
