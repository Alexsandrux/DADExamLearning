<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Pic. Processing</title>
</head>
<body>
<jsp:useBean id="picObj" class="eu.dice.beans.PicProcessorBean"> </jsp:useBean>
<%
	String inpp = request.getParameter("nume");
	String outp = request.getParameter("newNume");
	String xp = request.getParameter("xpoz");
	String yp = request.getParameter("ypoz");
	String wp = request.getParameter("width");
	String hp = request.getParameter("height");
	
	int rpp = picObj.processPicture(inpp, outp, xp, yp, wp, hp);
	
%>

<h1> Resp - pic process: </h1>

<%

if(rpp == 0)
{
	



%>
<h2>Success!</h2>
<%
}
else {
	

%>
<h2>Fail!</h2>
<%

}

%>
</body>
</html>