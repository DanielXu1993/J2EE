<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    用户名：<input type="text" userName="user.userName"><br/>
    密码：<input type="password" userName="user.pwd"><br/>
    <input type="submit" value="登录"><br/>
</form>
</body>
</html>
