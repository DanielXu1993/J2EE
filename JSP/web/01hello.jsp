<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.Date,java.text.*" %>
<%@taglib prefix="c" uri="" %>
<html>
<head>
    <title>第一个jsp页面</title>
</head>
<body>
<%
	SimpleDateFormat sdf = new SimpleDateFormat();
	String current = sdf.format(new Date());

	out.write("当前时间为: " + current);
%>

</body>
</html>
