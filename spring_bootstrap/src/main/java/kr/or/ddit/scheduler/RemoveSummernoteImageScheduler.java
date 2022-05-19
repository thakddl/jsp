package kr.or.ddit.scheduler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.dao.BoardDAOBean;
import kr.or.ddit.dao.NoticeDAOBean;
import kr.or.ddit.dao.PdsDAOBean;

public class RemoveSummernoteImageScheduler {

	private NoticeDAOBean noticeDAOBean;
	private BoardDAOBean boardDAOBean;
	private PdsDAOBean pdsDAOBean;
	private String filePath;

	public NoticeDAOBean getNoticeDAOBean() {
		return noticeDAOBean;
	}

	public void setNoticeDAOBean(NoticeDAOBean noticeDAOBean) {
		this.noticeDAOBean = noticeDAOBean;
	}

	public BoardDAOBean getBoardDAOBean() {
		return boardDAOBean;
	}

	public void setBoardDAOBean(BoardDAOBean boardDAOBean) {
		this.boardDAOBean = boardDAOBean;
	}

	public PdsDAOBean getPdsDAOBean() {
		return pdsDAOBean;
	}

	public void setPdsDAOBean(PdsDAOBean pdsDAOBean) {
		this.pdsDAOBean = pdsDAOBean;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	private static final Logger logger = LoggerFactory.getLogger(RemoveSummernoteImageScheduler.class);

	public void fileRemove() throws Exception {
		boolean existFile = false;

		File dir = new File(filePath);
		File[] files = dir.listFiles();

		if (files != null)
			for (File file : files) {
				existFile = false;
				existFile = (noticeDAOBean.selectNoticeByImage(file.getName()) != null)
						 || (boardDAOBean.selectBoardByImage(file.getName()) != null)
						 || (pdsDAOBean.selectPdsByImage(file.getName()) != null);

				if (existFile) {
					logger.info(file.getName() + "은 사용하는 파일입니다.");
				} else {
					logger.info(file.getName() + "은 사용하지 않습니다.");
					if (file.exists()) {
						file.delete();
					}
				}
			}

	}

}
