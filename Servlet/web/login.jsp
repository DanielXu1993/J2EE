<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form userName="login" action="${pageContext.request.contextPath}/login" method="post">
    用户名:<input type="text" userName="username"/><br/>
    <input type="submit" value="post提交">
</form>
<hr/>
<form userName="login" action="${pageContext.request.contextPath}/login" method="get">
    用户名:<input type="text" userName="username"/><br/>
    <input type="submit" value="get提交">
</form>
</body>
</html>
