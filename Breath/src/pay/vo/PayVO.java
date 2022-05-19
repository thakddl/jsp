package pay.vo;

public class PayVO {
	
	private String payNum;
	private String payDt;
	private String exprtDt;
	private String memId;
	private String clientId;
	private String trainerId;
	private int payMethNum;
	private int payAmount;
	
	public String getPayNum() {
		return payNum;
	}
	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}
	public String getPayDt() {
		return payDt;
	}
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}
	public String getExprtDt() {
		return exprtDt;
	}
	public void setExprtDt(String exprtDt) {
		this.exprtDt = exprtDt;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	public int getPayMethNum() {
		return payMethNum;
	}
	public void setPayMethNum(int payMethNum) {
		this.payMethNum = payMethNum;
	}
	public int getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}
}
