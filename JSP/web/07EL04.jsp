<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL的表达式计算</title>
</head>
<body>
<div>
    ${10+5}<br/>
    ${10/3}<%--3.3333333333333335--%>
    ${true && true}
    ${10!=10}
</div>
<hr/>
<div>
    <%--EL表达式的判空操作--%>
    <%
        //String name = "eric";
        //String name = null;
        String name = "";
        pageContext.setAttribute("name", name);
    %>
    判断null: ${name == null}<br/>
    判断"": ${name == ""}<br/>


    判空：${name == null || name == ""}<br/>
    判空：${empty name}<br/>
</div>
</body>
</html>
