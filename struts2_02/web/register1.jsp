<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user_register1.action" method="post">
    用户名：<input type="text" userName="userName"><br/>
    密码:<input type="password" userName="pwd"><br/>
    年龄:<input type="text" userName="age"><br/>
    生日:<input type="text" userName="birth"><br/>
    <input type="submit" value="注册">

</form>
</body>
</html>
