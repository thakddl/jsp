package member.vo;

public class MemberVO {
	private String memId;
	private String athrtCode;
	private String memPass;
	private String memNm;
	private String nickName;
	private String gender;
	private String email;
	private String hp;
	private String rgstDt;
	private String birthDt;
	private String status;
	private String zip;
	private String memAdd;
	private String detailAdd;
	private String evdDoc;
	private String pymntMthd;
	
	public MemberVO() {
	}
	
	public String getMemPass() {
		return memPass;
	}

	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}

	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getAthrtCode() {
		return athrtCode;
	}
	public void setAthrtCode(String athrtCode) {
		this.athrtCode = athrtCode;
	}
	public String getMemNm() {
		return memNm;
	}
	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getRgstDt() {
		return rgstDt;
	}
	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}
	public String getBirthDt() {
		return birthDt;
	}
	public void setBirthDt(String birthDt) {
		this.birthDt = birthDt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getMemAdd() {
		return memAdd;
	}
	public void setMemAdd(String memAdd) {
		this.memAdd = memAdd;
	}
	public String getDetailAdd() {
		return detailAdd;
	}
	public void setDetailAdd(String detailAdd) {
		this.detailAdd = detailAdd;
	}
	public String getEvdDoc() {
		return evdDoc;
	}
	public void setEvdDoc(String evdDoc) {
		this.evdDoc = evdDoc;
	}
	public String getPymntMthd() {
		return pymntMthd;
	}
	public void setPymntMthd(String pymntMthd) {
		this.pymntMthd = pymntMthd;
	}
	
}
