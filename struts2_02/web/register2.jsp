<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user_register2.action" method="post">
    用户名：<input type="text" name="user.name"><br/>
    密码:<input type="password" name="user.pwd"><br/>
    年龄:<input type="text" name="user.age"><br/>
    生日:<input type="text" name="user.birth"><br/>
    <input type="submit" value="注册">

</form>
</body>
</html>
