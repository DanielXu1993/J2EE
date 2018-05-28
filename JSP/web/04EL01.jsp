<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
<div>
    <%--
        EL表达式：向浏览器输出域对象中的变量值或者表达式的计算结果
        使用EL表达式替换到jsp中的表达式
        语法： ${变量或表达式}
    --%>
    <%
        pageContext.setAttribute("name", "rose");
    %>
    ${name}<br/><%--从四个域中从小到大搜索--%>
    EL表达式：${pageScope.name}<%--从指定域中获取数据--%>
</div>
</body>
</html>
