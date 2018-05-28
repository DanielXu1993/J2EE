<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp:forward标签</title>
</head>
<body>
<div>
    <%--转发标签--%>
    <jsp:forward page="/07EL04.jsp"></jsp:forward>
    <%--等价于
        <%
        request.getRequestDispatcher("/07EL04.jsp").forward(request, response);
        %>
    --%>
    <%--转发标签--%>
</div>
</body>
</html>
