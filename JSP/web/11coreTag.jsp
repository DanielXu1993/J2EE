<%@ page import="cn01.xyh.entity.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>core核心标签库</title>
</head>
<body>
<div>
    <%--核心标签库的重点标签：
        保存数据：<c:set></c:set>
        获取数据：<c:out value=""></c:out>
        单条件判断:<c:if test=""></c:if>
        多条件判断:
              <c:choose></c:choose>
                <c:when test=""></c:when>
              <c:otherwise></c:otherwise>
        循环数据:
              <c:forEach></c:forEach>
              <c:forTokens items="" delims=""></c:forTokens>
        重定向:
              <c:redirect></c:redirect>
    --%>
</div>
<div>
    <%--set标签：保存数据(保存到域中，默认保存到page域中)--%>
    <c:set var="userName" value="rose" scope="request"></c:set>
    ${requestScope.userName}
    <%--set标签--%>
    <hr/>
    <%--out标签：从域中获取数据,当value的值为null时显示默认值--%>
    <%
        String msg = null;
        pageContext.setAttribute("msg", msg);
    %>
    <c:out value="${userName}"></c:out><br/>
    <c:out value="${msg}" default="默认值"></c:out>
    <%--out标签--%>
    <hr/>

    <%--if标签：单条件判断--%>
    <c:if test="${empty msg}">
        条件成立
    </c:if>
    <%--if标签--%>
    <hr/>

    <%--choose标签：多条件判断--%>
    <c:set var="score" value="66"></c:set>
    <c:choose>
        <c:when test="${score>=90 && score<=100}">优秀</c:when>
        <c:when test="${score>=80 && score<90}">良好</c:when>
        <c:when test="${score>=70 && score<80}">一般</c:when>
        <c:when test="${score>=60 && score<70}">及格</c:when>
        <c:otherwise>不及格</c:otherwise>
    </c:choose>
    <%--choose标签--%>
    <hr/>

    <%--forEach标签--%>
    <%
        // List
        List<Student> list = new ArrayList<>();
        list.add(new Student("rose", 18));
        list.add(new Student("jack", 28));
        list.add(new Student("lucy", 38));
        pageContext.setAttribute("students", list);

        // Map
        Map<String, Student> map = new HashMap<>();
        map.put("100", new Student("rose", 18));
        map.put("101", new Student("jack", 28));
        map.put("102", new Student("lucy", 38));
        pageContext.setAttribute("map", map);
    %>
    <%--
        begin="" :从哪个元素开始遍历，默认从第一个元素开始
        end="" :到哪个元素结束，默认到集合结尾结束
        items="":需要遍历的数据(集合)
        step="" :步长(每次加几)，默认为1
        varStatus="":当前正在遍历的第几个元素，从1开始
        var="":每个元素的名称
    --%>
    <c:forEach items="${students}" step="1" varStatus="varSta" var="student">
        序号：${varSta.count} -- 姓名：${student.userName} -- 年龄：${student.age}<br/>
    </c:forEach>
    <hr/>

    <c:forEach items="${map}" var="entry">
        编号：${entry.key} -- 姓名：${entry.value.userName} -- 年龄：${entry.value.age}<br/>
    </c:forEach>
    <%--forEach标签--%>
    <hr/>


    <%--forTokenb标签：循环特殊字符串--%>
    <%
        String str = "java-php-net-平面";
        pageContext.setAttribute("str", str);
    %>
    <c:forTokens items="${str}" delims="-" var="s">
        ${s}<br/>
    </c:forTokens>
    <%--forTokenb标签--%>

    <%--redirect标签：重定向--%>
    <%--<c:redirect url="http://www.baidu.com"></c:redirect>--%>
    <%--redirect标签--%>
</div>
</body>
</html>
