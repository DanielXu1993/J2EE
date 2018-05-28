<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp:param标签</title>
</head>
<body>
<div>
    <%--jsp:param标签用于转发时的参数传递--%>
    <jsp:forward page="/index.jsp">
        <jsp:param name="name" value="jack"/>
        <jsp:param name="password" value="123456"/>
    </jsp:forward>
</div>
</body>
</html>
