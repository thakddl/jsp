package common.vo;

import java.util.Date;

public class AtchFileVO {
	private String atchId;	        // 첨부파일ID
	private Date upldDt;					// 생성일자
	private String memId;					// 작성자
	private long fileSNum = 1;                // 파일순번
	private String filePath;           // 파일저장경로
	private String saveNm;              // 저장파일명
	private String orgnlNm;            // 원본파일명
	private String fileExtsn;               // 파일확장자
	private String fileContents;            // 파일내용
	private long fileSize = 0;              // 파일크기
	
	public String getAtchId() {
		return atchId;
	}
	public void setAtchFileId(String atchId) {
		this.atchId = atchId;
	}
	public Date getUpldDt() {
		return upldDt;
	}
	public void setUpldDt(Date upldDt) {
		this.upldDt = upldDt;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public long getFileSNum() {
		return fileSNum;
	}
	public void setFileSNum(long fileSNum) {
		this.fileSNum = fileSNum;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getSaveNm() {
		return saveNm;
	}
	public void setSaveNm(String saveNm) {
		this.saveNm = saveNm;
	}
	public String getOrgnlNm() {
		return orgnlNm;
	}
	public void setOrgnlNm(String orgnlNm) {
		this.orgnlNm = orgnlNm;
	}
	public String getFileExtsn() {
		return fileExtsn;
	}
	public void setFileExtsn(String fileExtsn) {
		this.fileExtsn = fileExtsn;
	}
	public String getFileContents() {
		return fileContents;
	}
	public void setFileContents(String fileContents) {
		this.fileContents = fileContents;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
}
