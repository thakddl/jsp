package atch.Service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import atch.DAO.AtchFileDaoImpl;
import atch.DAO.IAtchFileDao;
import atch.VO.AtchFileVO;

public class AtchFileServiceImpl implements IAtchFileService{
	
	private static final String UPLOAD_DIR = "upload_files";
	
	private static IAtchFileService fileService;
	private IAtchFileDao atchFileDao;
	
	private AtchFileServiceImpl() {
		atchFileDao = AtchFileDaoImpl.getInstance();
	}
	
	public static IAtchFileService getInstance() {
		if(fileService == null) {
			fileService = new AtchFileServiceImpl();
		}
		
		return fileService;
	}
	
	@Override
	public AtchFileVO saveAtchFileList(HttpServletRequest req) throws Exception {
		
		String uploadPath = "D:/A_TeachingMaterial/4.MiddleProject/workspace/CodingPeople/WebContent/uploadfile";
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		AtchFileVO atchFileVO = null;
		
		String fileName = "";
		
		boolean isFirstFile = true;	// 첫번째 파일 여부
		
		for(Part part : req.getParts()) {
			
			fileName = getFileName(part);
			if(fileName != null && !fileName.equals("")) {
				// 파일이 비어있지 않은 경우...(업로드할 파일이 존재하는 경우)
				
				if(isFirstFile) { // 첫번째 업로드 파일인 경우...
					
					isFirstFile = false;
					
					// 파일 기본정보 저장하기
					atchFileVO = new AtchFileVO();
					
					// 기본 파일정보 저장(VO에 atchFileId가 저장된다.)
					atchFileDao.insertAtchFile(atchFileVO);
					
				}
				
				String orignFileName = fileName; // 원본 파일명
				long fileSize = part.getSize();  // 파일 사이즈
				String saveFileName = "";		 // 저장 파일명
				String saveFilePath = "";		 // 저장 파일경로
				File storeFile = null; 			 // 저장 파일 객체
				
				do {
					// 저장파일명 추출
					saveFileName = UUID.randomUUID().toString().replace("-", "");
					
					saveFilePath = uploadPath + File.separator + saveFileName;
					storeFile = new File(saveFilePath);
					
				} while(storeFile.exists()); // 저장파일명 중복되는지  체크
				
				// 확장명 추출
				String filExtension = orignFileName.lastIndexOf(".") < 0 ? "" : orignFileName.substring(orignFileName.lastIndexOf(".") + 1);
				
				part.write(saveFilePath); // 업로드 파일 저장
				
				atchFileVO.setStreFileNm(saveFileName);
				atchFileVO.setFileSize(fileSize);
				atchFileVO.setOrignlFileNm(orignFileName);
				atchFileVO.setFileStreCours(saveFilePath);
				atchFileVO.setFileExtsn(filExtension);
				
				// 파일 세부정보 저장
				atchFileDao.insertAtchFileDetail(atchFileVO);
				
				part.delete(); // 임시 업로드 파일 삭제하기
				
					
			}
		}
		
		return atchFileVO;
	}
	
	private String getFileName(Part part) {
		
			for(String content : part.getHeader("Content-Disposition").split(";")) {
				
				if(content.trim().startsWith("filename")) {
					return content.substring(content.indexOf("=") + 1).trim().replace("\"", "");
				}
				
			}
			
			
			return null;
		}
	

	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO) throws SQLException {
		return atchFileDao.getAtchFileList(atchFileVO);
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO) throws SQLException {
		return atchFileDao.getAtchFileDetail(atchFileVO);
	}

}
