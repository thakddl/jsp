<%@page import="admin.vo.ReportVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// servlet에서 값 가져 오기
	List<ReportVO> reportList = (List<ReportVO>) request.getAttribute("reportList");
%>
[
<%
	int reSize = reportList.size();

	if (reportList != null && reSize > 0) {
		
		for (int i = 0; i < reSize; i++) {
			ReportVO vo = reportList.get(i);
			if (i > 0) out.print(",");
%>			
			{
				"rprtNum"	: "<%=vo.getRprtNum() %>",
				"rprtDt"	: "<%=vo.getRprtDt() %>",
				"rprtRsn"	: "<%=vo.getRprtRsn() %>",
				"rprtId"	: "<%=vo.getRprtId() %>",
				"rprtDId"	: "<%=vo.getRprtDId() %>"	
			}			
<%			
		} // for end
	} // if end
	
%>
]




