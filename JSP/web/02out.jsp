<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>out对象</title>
</head>
<body>
<span>
    <%
        out.write("abc");
        response.getWriter().write("123");
        // 输出的结果为123abc

    %>
</span>
</body>
</html>
