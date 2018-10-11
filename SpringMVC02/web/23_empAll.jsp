<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>批量添加员工</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/emp/addAll.action" method="post">
    <table border="2" align="center">
        <caption><h2>批量注册员工</h2></caption>
        <tr>
            <td><input type="text" name="empList[0].username" value="哈哈0"></td>
            <td><input type="text" name="empList[0].salary" value="7000"></td>
        </tr>
        <tr>
            <td><input type="text" name="empList[1].username" value="哈哈1"></td>
            <td><input type="text" name="empList[1].salary" value="8000"></td>
        </tr>
        <tr>
            <td><input type="text" name="empList[2].username" value="哈哈2"></td>
            <td><input type="text" name="empList[2].salary" value="9000"></td>
        </tr>
        <tr>
            <td><input type="text" name="empList[3].username" value="哈哈3"></td>
            <td><input type="text" name="empList[3].salary" value="10000"></td>
        </tr>
        <tr>
            <td><input type="text" name="empList[4].username" value="哈哈4"></td>
            <td><input type="text" name="empList[4].salary" value="11000"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>
</body>
</html>
