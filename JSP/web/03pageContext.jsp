<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>pageContext</title>
</head>
<body>
<div>
    <%
        // 1.可以获取其他8个内置对象
        // 在自定义标签的时候会频繁的使用pageContext对象
        response.getWriter().write((pageContext.getOut() == out) + "");// true
    %>
</div>
<hr/>
<div>
    <%
        // 2.本身是一个域对象,作用域是当前jsp页面,默认情况下保存到page域中
        pageContext.setAttribute("message", "this is page message");
        // 还可以保存到其他的域对象中
        pageContext.setAttribute("requestMessage", "this is request message", PageContext.REQUEST_SCOPE);
    %>
    <%
        String message = (String) pageContext.getAttribute("message");
        out.write(message);
    %>
    <br/>
    <%=request.getAttribute("requestMessage")%>
    <br/>
    <%=pageContext.getAttribute("requestMessage", PageContext.REQUEST_SCOPE)%>
</div>
</body>
</html>
