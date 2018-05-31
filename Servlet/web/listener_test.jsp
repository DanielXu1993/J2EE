<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
test
<div>
    <%
        request.setAttribute("cn", "China");
        session.setAttribute("userName", "用户名");
    %>
</div>

</body>
</html>
