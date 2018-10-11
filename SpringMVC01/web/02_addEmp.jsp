<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>struts2+spring+jdbc+oracle</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/register.action" method="post">
    <table border="2" align="center">
        <tr>
            <th>姓名</th>
            <td><input type="text" name="emp.username"></td>
        </tr>
        <tr>
            <th>薪水</th>
            <td><input type="text" name="emp.salary"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>
</body>
</html>
