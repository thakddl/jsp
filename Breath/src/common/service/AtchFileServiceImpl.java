package common.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import common.dao.AtchFileDaoImpl;
import common.dao.IAtchFileDao;
import common.vo.AtchFileVO;

public class AtchFileServiceImpl implements IAtchFileService{
	public static final String UPLOAD_DIR = "upload_files";
	public static IAtchFileService atchFileService;
	private IAtchFileDao atchFileDao;
	
	private AtchFileServiceImpl() {
		atchFileDao = AtchFileDaoImpl.getInstance();
	}

	public static IAtchFileService getInstance() {
		if (atchFileService == null) {
			atchFileService = new AtchFileServiceImpl();
		}
		return atchFileService;
	}
	
	@Override
	public AtchFileVO saveAtchFileList(HttpServletRequest req) throws Exception {
		
		String uploadPath = "D:/D_Other/upload_files";
		
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		AtchFileVO atchFileVO = null;
		
		String fileName = "";
		boolean isFirstFile = true;
		
		for (Part part : req.getParts()) {
			
			fileName = getFileName(part);
			if (fileName != null && !fileName.equals("")) {
				if (isFirstFile) {
					isFirstFile = false;
					
					atchFileVO = new AtchFileVO();
					
					atchFileDao.insertAtchFile(atchFileVO);
				}
				String orgnlNm = fileName;
				String saveNm = "";
				String filePath = "";
				long fileSize = part.getSize();
				File storeFile = null;
				
				do {
					saveNm = UUID.randomUUID().toString().replace("-", "");
					
					filePath = uploadPath + "/" + saveNm;
					
					storeFile = new File(filePath);
					
				} while(storeFile.exists());
				
				// 확장명 추출
				String fileExtsn = orgnlNm.lastIndexOf(".") < 0 ? "" : orgnlNm.substring(orgnlNm.indexOf(".") + 1);
				
				part.write(filePath);
				
				atchFileVO.setOrgnlNm(orgnlNm);
				atchFileVO.setSaveNm(saveNm);
				atchFileVO.setFileSize(fileSize);
				atchFileVO.setFilePath(filePath);
				atchFileVO.setFileExtsn(fileExtsn);;
				
				atchFileDao.insertAtchFileDetail(atchFileVO);
				
				part.delete();
			}
		}
		return atchFileVO;
	}

	private String getFileName(Part part) {
		
		for (String content : part.getHeader("Content-Disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=") + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	@Override
	public List<AtchFileVO> getAtchFileDetailList(AtchFileVO atchFileVO) throws Exception {
		return atchFileDao.getAtchFileDetailList(atchFileVO);
	}

	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO) throws SQLException {
		return atchFileDao.getAtchFileList(atchFileVO);
	}

	@Override
	public AtchFileVO saveAtchFileList1(HttpServletRequest req) throws Exception {
		String uploadPath = "D:/D_Other/upload_files";
		
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		AtchFileVO atchFileVO = null;
		
		String fileName = "";
		boolean isFirstFile = true;
		
		for (Part part : req.getParts()) {
			
			fileName = getFileName(part);
			if (fileName != null && !fileName.equals("")) {
				if (isFirstFile) {
					isFirstFile = false;
					
					atchFileVO = new AtchFileVO();
					
					atchFileDao.insertAtchFile(atchFileVO);
				}
				String orgnlNm = fileName;
				String saveNm = "";
				String filePath = "";
				long fileSize = part.getSize();
				File storeFile = null;
				
				do {
					saveNm = UUID.randomUUID().toString().replace("-", "") + orgnlNm;
					
					filePath = uploadPath + "/" + saveNm;
					
					storeFile = new File(filePath);
					
				} while(storeFile.exists());
				
				// 확장명 추출
				String fileExtsn = orgnlNm.lastIndexOf(".") < 0 ? "" : orgnlNm.substring(orgnlNm.indexOf(".") + 1);
				
				part.write(filePath);
				
				atchFileVO.setOrgnlNm(orgnlNm);
				atchFileVO.setSaveNm(saveNm);
				atchFileVO.setFileSize(fileSize);
				atchFileVO.setFilePath(filePath);
				atchFileVO.setFileExtsn(fileExtsn);;
				
				atchFileDao.insertAtchFileDetail(atchFileVO);
				
				part.delete();
			}
		}
		return atchFileVO;
	}
}
