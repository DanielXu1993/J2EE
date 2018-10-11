<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>演示适配器</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/add.action" method="post">
    员工姓名:<input type="text" name="username"/>
    <input type="submit" value="提交">
</form>
</body>
</html>
