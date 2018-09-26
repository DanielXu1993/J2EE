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
        //String userName = "eric";
        //String userName = null;
        String userName = "";
        pageContext.setAttribute("userName", userName);
    %>
    判断null: ${userName == null}<br/>
    判断"": ${userName == ""}<br/>


    判空：${userName == null || userName == ""}<br/>
    判空：${empty userName}<br/>
</div>
</body>
</html>
