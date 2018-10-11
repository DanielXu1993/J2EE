<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="${pageContext.request.contextPath}/person/register.action" method="POST">
    <table border="2" align="center">
        <caption><h2>普通用户注册</h2></caption>
        <tr>
            <th>姓名</th>
            <td><input type="text" name="user.username" value="${user.username}"/></td>
        </tr>
        <tr>
            <th>月薪</th>
            <td><input type="text" name="user.salary" value="${empty user.salary?7000:user.salary}"/></td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="注册" style="width:111px"/>
            </td>
        </tr>
    </table>
</form>
<hr/>
<form action="${pageContext.request.contextPath}/person/register.action" method="POST">
    <table border="2" align="center">
        <caption><h2>管理员用户注册</h2></caption>
        <tr>
            <th>姓名</th>
            <td><input type="text" name="admin.username" value="${admin.username}"/></td>
        </tr>
        <tr>
            <th>月薪</th>
            <td><input type="text" name="admin.salary" value="${empty admin.salary?8000:admin.salary}"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="注册" style="width:111px"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
