package subscribe.vo;

public class SubscribeVO {
	private String clientId;
	private String trainerId;
	private String startDt;
	private String endDt;
	private String status;
	
	public SubscribeVO() {
		
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
	public String getStartDt() {
		return startDt;
	}
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SubscribeVO [clientId=" + clientId + ", trainerId=" + trainerId + ", startDt=" + startDt + ", endDt="
				+ endDt + ", status=" + status + "]";
	}
	
	
}
