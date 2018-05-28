<%@ page import="cn01.xyh.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用EL表达式输出对象类型数据</title>
</head>
<body>
<div>
    <%
        Student student = new Student("eric", 20);
        pageContext.setAttribute("student", student);
    %>

    <%--等价于((Student) pageContext.findAttribute("student")).getName()--%>
    ${student.name}<%--点等价于调用对象的getXXX()方法--%>
</div>
</body>
</html>
