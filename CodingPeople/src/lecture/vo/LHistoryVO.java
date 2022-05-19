package lecture.vo;

public class LHistoryVO {
	
	private int lhistoryNo;
	private String memId;
	private String courseId;
	private String applicationDate;
	private String applicationKey;
	private String coursePrice;
	private String memCoin;
	private String courseTitle;
	
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getMemCoin() {
		return memCoin;
	}
	public void setMemCoin(String memCoin) {
		this.memCoin = memCoin;
	}
	public String getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(String coursePrice) {
		this.coursePrice = coursePrice;
	}
	public int getLhistoryNo() {
		return lhistoryNo;
	}
	public void setLhistoryNo(int lhistoryNo) {
		this.lhistoryNo = lhistoryNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getApplicationKey() {
		return applicationKey;
	}
	public void setApplicationKey(String applicationKey) {
		this.applicationKey = applicationKey;
	}
	
	
}
