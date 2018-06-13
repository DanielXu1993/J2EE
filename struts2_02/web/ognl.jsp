<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试迭代标签</title>
</head>
<body>
<div>
    <br/>一、测试List迭代<br/>
    <s:iterator var="user" value="#request.list">
        <s:property value="#user.id"/>
        <s:property value="#user.name"/><br/>
    </s:iterator>

    <br/>二、测试Map迭代<br/>
    <s:iterator var="entry" value="#request.map">
        <s:property value="#entry.key"/> ==
        <s:property value="#entry.value.name"/><br/>
    </s:iterator>
</div>
</body>
</html>
