<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    success.jsp<br/>
    成功<br/>
    ${requestScope.message}</div>
<hr/>
<div>
    姓名:${emp.username}<br>
    性别:${emp.gender}<br>
    入职时间:${emp.hiredate}<br>
    <hr/>
    入职时间:
    <fmt:formatDate
            value="${emp.hiredate}"
            type="date"
            dateStyle="medium"/>
    <%--
        1) fmt:formateDate来源于http://java.sun.com/jsp/jstl/fmt
        2) fmt:formateDate的作用是格式化日期的显示
        3) value表示需要格式化的值
        4) type表示要显示的日期类型.date(仅日期),time(仅时间),both(都显示)
        5) dateStyle表示要显示的日期的风格:short/medium/default/long/full
    --%>
</div>
</body>
</html>
