<%@ page import="cn01.xyh.entity.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式输出集合数据</title>
</head>
<body>
<div>
    <%
        List<Student> list = new ArrayList<>();
        list.add(new Student("rose", 18));
        list.add(new Student("jack", 28));
        list.add(new Student("lucy", 38));
        pageContext.setAttribute("students", list);
    %>
    ${students[0].name} -- ${students.get(0).age}
</div>
<hr/>
<div>
    <%
        Map<String, Student> map = new HashMap<>();
        map.put("100", new Student("rose", 18));
        map.put("101", new Student("jack", 28));
        map.put("102", new Student("lucy", 38));
        pageContext.setAttribute("map", map);
    %>
    ${map["100"].name} -- ${map["100"].age}<br/>
    ${map.get("101").name} -- ${map.get("101").age}<br/>
    ${map["102"].name} -- ${map["102"].age}<br/>
</div>
</body>
</html>
