<%@page import="java.util.List"%>
<%@page import="admin.vo.AdminVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<AdminVO> list = (List<AdminVO>) request.getAttribute("blackList");
%>
[
<%
	int reSize = list.size();

	if (list != null && reSize > 0) {
		
		for (int i = 0; i < reSize; i++) {
			AdminVO vo = list.get(i);
			if (i > 0) out.print(",");
%>			
			{
				"memId"		: "<%=vo.getMemId() %>",
				"athrtCode"	: "<%=vo.getAthrtCode() %>",
				"status"	: "<%=vo.getStatus() %>",
				"memNm"		: "<%=vo.getMemNm() %>",
				"nickName"	: "<%=vo.getNickName() %>"	
			}			
<%			
		} // for end
	} // if end
	
%>
]