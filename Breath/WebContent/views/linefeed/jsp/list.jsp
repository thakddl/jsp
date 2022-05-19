<%@page import="linefeed.vo.LineFeedVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<LineFeedVO> lineFeedList = (List<LineFeedVO>) request.getAttribute("lineFeedList");
%>
	{
	"data" : [
<%
	for (int i = 0; i < lineFeedList.size(); i++) {
		LineFeedVO lv = lineFeedList.get(i);
		if (lv.getStatus() == "4") {
			continue;
		}
		
		if (i > 0 ) out.print(",");
%>			
		{
			"lnfdNum" : "<%=lv.getLnfdNum()%>",
			"postDt" : "<%=lv.getPostDt()%>",
<%
			if (lv.getContent() != null) {
%>				
			"content" : "<%=lv.getContent()%>",
<%			
			} else {
%>
			"content" : "",				
<%			
			}
%>
			"fileExtns" : "<%=lv.getFileExtns()%>",	
			"filePath" : "<%=lv.getFilePath().replace("\\", "/")%>",
			"status" : "<%=lv.getStatus()%>"
			
				
		}
<%		
	} // for end
%>
			]
	}
	