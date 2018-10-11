<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>批量删除员工</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/emp/deleteAll.action" method="post">
    <table border="2" align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
        </tr>

        <tr>
            <td><input type="checkbox" name="ids" value="1">1</td>
            <td>哈哈</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="ids" value="2">2</td>
            <td>呵呵</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="ids" value="3">3</td>
            <td>嘻嘻</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="ids" value="4">4</td>
            <td>笨笨</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="ids" value="5">5</td>
            <td>聪聪</td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="删除"></td>
        </tr>
    </table>
</form>
</body>
</html>
