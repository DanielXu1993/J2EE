<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="${pageContext.request.contextPath}/user/register.action" method="post">
    <table border="2" align="center">
        <caption><h2>用户注册</h2></caption>
        <tr>
            <th>姓名</th>
            <td><input type="text" name="username"/></td>
        </tr>

        <tr>
            <th>薪水</th>
            <td><input type="text" name="salary"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="注册"/></td>
        </tr>
    </table>
</form>
<hr/>
<form action="${pageContext.request.contextPath}/user/login.action" method="post">
    <table border="2" align="center">
        <caption><h2>用户登录</h2></caption>
        <tr>
            <th>姓名</th>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="登录"/></td>
        </tr>
    </table>
</form>
</body>
</html>
