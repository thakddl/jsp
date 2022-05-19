package pay.sevice;

import pay.vo.BuyerVO;
import pay.vo.PayVO;

public interface IPayService {

	/**
	 * 결제 정보 입력을 위한 모달창 오픈 시 기본 정보들을 가져오는 메소드
	 * @param memId 구매자 정보를 가져올 회원 ID
	 * @param trainerId 상품명과 가격을 가져올 트레이너 ID
	 * @return 위의 정보가 담긴 BuyerVO 객체 반환
	 */
	public BuyerVO getBuyerInfo(String memId, String trainerId);

	/**
	 * 결제 정보를 DB에 저장하기 위한 메소드
	 * @param pv 결제 정보가 담긴 객체
	 * @return 성공 : 1, 실패 : 0
	 */
	public int inserPay(PayVO pv);
}
