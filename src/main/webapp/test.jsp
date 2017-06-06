<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	OK
	<form action="<%=request.getContextPath()%>/executeServlet" method="post">
		<input type="submit" value="获取所有">
	</form>

	<form action="<%=request.getContextPath()%>/executeServlet" method="get">
		<input type="submit" value="刷新缓存">
	</form>
</body>
</html>