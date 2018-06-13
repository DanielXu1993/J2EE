<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>valueStack</title>
</head>
<body>
<div>
    <br/>1.取根元素的值<br/>
    <s:property value="user.id"/><br/>
    <s:property value="user.name"/><br/>
    <s:property value="user.address"/><br/>
    <s:property value="user.address.city"/><br/>
    <s:property value="user.address.province"/><br/>
    <br/>2.取非根元素的值<br/>
    <%--#相当于ActionContext.getValueStack--%>
    <s:property value="#request.request_data"/><br/>
    <s:property value="#session.session_data"/><br/>
    <s:property value="#application.application_data"/><br/>
</div>

</body>
</html>
