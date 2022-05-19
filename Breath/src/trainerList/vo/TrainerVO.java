package trainerList.vo;

public class TrainerVO {
	private String subscribeCnt;
	private String membershipCnt;
	private String trainerNikNm;
	private String excsNm;
	public TrainerVO() {
		
	}
	
	public String getSubscribeCnt() {
		return subscribeCnt;
	}
	public void setSubscribeCnt(String subscribeCnt) {
		this.subscribeCnt = subscribeCnt;
	}
	public String getMembershipCnt() {
		return membershipCnt;
	}
	public void setMembershipCnt(String membershipCnt) {
		this.membershipCnt = membershipCnt;
	}
	public String getTrainerNikNm() {
		return trainerNikNm;
	}
	public void setTrainerNikNm(String trainerNikNm) {
		this.trainerNikNm = trainerNikNm;
	}
	public String getExcsNm() {
		return excsNm;
	}
	public void setExcsNm(String excsNm) {
		this.excsNm = excsNm;
	}
	public TrainerVO(String subscribeCnt, String membershipCnt, String trainerNikNm, String excsNm) {
		super();
		this.subscribeCnt = subscribeCnt;
		this.membershipCnt = membershipCnt;
		this.trainerNikNm = trainerNikNm;
		this.excsNm = excsNm;
	}
	
	
}
