package kr.or.ddit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.command.Criteria;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;

import kr.or.ddit.command.PdsModifyCommand;
import kr.or.ddit.command.PdsRegistCommand;
import kr.or.ddit.util.GetAttachesByMultipartFileAdapter;

@Controller
@RequestMapping("/pds")
public class PdsController {

	@Resource(name = "pdsService")
	private PdsService service;

	@Resource(name = "fileUploadPath")
	private String fileUploadPath;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void main() throws Exception {
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Criteria cri, Model model) throws Exception {

		Map<String, Object> dataMap = service.getList(cri);
		model.addAttribute("dataMap", dataMap);
	}

	@RequestMapping(value = "/registForm", method = RequestMethod.GET)
	public void registForm() throws Exception {
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String regist(PdsRegistCommand pdsCMD, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/pds/list.do";

		// file저장 -> List<AttachVO>
		String savePath = this.fileUploadPath;
		List<AttachVO> attachList = GetAttachesByMultipartFileAdapter.save(pdsCMD.getUploadFile(), savePath);

		// DB저장
		PdsVO pds = pdsCMD.toPdsVO();
		pds.setAttachList(attachList);
		pdsCMD.setTitle((String) req.getAttribute("XSStitle"));
		service.regist(pds);

		// output
		rttr.addFlashAttribute("from", "regist");

		return url;
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(int pno, String from, ModelAndView mnv) throws Exception {
		String url = "pds/detail";

		PdsVO pds = null;
		if (from != null && from.equals("list")) {
			pds = service.read(pno);
			url = "redirect:/pds/detail.do?pno=" + pno;
		} else {
			pds = service.getPds(pno);
		}

		// 파일명 재정의
		if (pds != null) {
			List<AttachVO> attachList = pds.getAttachList();
			if (attachList != null) {
				for (AttachVO attach : attachList) {
					String fileName = attach.getFileName().split("\\$\\$")[1];
					attach.setFileName(fileName);
				}
			}
		}

		mnv.addObject("pds", pds);
		mnv.setViewName(url);

		return mnv;
	}

	@RequestMapping(value = "/getFile", method = RequestMethod.GET, produces = "text/plain;charset:utf-8")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(int ano) throws Exception {

		ResponseEntity<byte[]> entity = null;

		AttachVO attach = service.getAttachByAno(ano);

		String fileName = attach.getFileName();
		String savedPath = this.fileUploadPath;

		InputStream in = null;
		try {
			in = new FileInputStream(new File(savedPath, fileName));
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			in.close();
		}

		return entity;
	}

	@RequestMapping(value = "/modifyForm", method = RequestMethod.GET)
	public ModelAndView modifyForm(int pno, ModelAndView mnv) throws Exception {
		String url = "pds/modifyForm";

		PdsVO pds = service.getPds(pno);

		// 파일명 재정의
		if (pds != null) {
			List<AttachVO> attachList = pds.getAttachList();
			if (attachList != null) {
				for (AttachVO attach : attachList) {
					String fileName = attach.getFileName().split("\\$\\$")[1];
					attach.setFileName(fileName);
				}
			}
		}

		mnv.addObject("pds", pds);
		mnv.setViewName(url);

		return mnv;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST, produces = "text/plain;charset:utf-8")
	public String modify(PdsModifyCommand modifyReq, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/pds/detail.do";

		// 파일 삭제
		if(modifyReq.getDeleteFile()!=null && modifyReq.getDeleteFile().length > 0) {
			for(String anoStr:modifyReq.getDeleteFile()) {
	            int ano = Integer.parseInt(anoStr);
	            AttachVO attach = service.getAttachByAno(ano);
	            
	            File deleteFile = new File(attach.getUploadPath(),attach.getFileName());
	            
	            if(deleteFile.exists()) {
	               deleteFile.delete(); // file 삭제
	            }
	            service.removeAttachByAno(ano); // db삭제
	         }
		}
		
		// 파일 저장
		List<AttachVO> attachList = GetAttachesByMultipartFileAdapter.save(modifyReq.getUploadFile(), fileUploadPath);
		
		// PdsVO setting
		PdsVO pds = modifyReq.toPdsVO();
		pds.setAttachList(attachList);
		pds.setTitle(HTMLInputFilter.htmlSpecialChars(pds.getTitle()));

		// DB 저장
		service.modify(pds);

		rttr.addAttribute("pno", pds.getPno());
		rttr.addFlashAttribute("from", "modify");

		return url;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(int pno, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/pds/detail.do";

		// 첨부파일 삭제
		List<AttachVO> attachList = service.getPds(pno).getAttachList();
		if(attachList != null) {
			for(AttachVO attach : attachList) {
				File target = new File(attach.getUploadPath(), attach.getFileName());
				if(target.exists()) {
					target.delete();
				}
			}
		}
		
		//DB삭제
		service.remove(pno);

		rttr.addAttribute("pno", pno);
		rttr.addFlashAttribute("from", "remove");

		return url;
	}

}