<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="${pageContext.request.contextPath}/user/register.action" method="POST">
    <table border="2" align="center">
        <caption><h2>用户注册</h2></caption>
        <tr>
            <th>姓名</th>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <th>月薪</th>
            <td><input type="text" name="salary" value="7000"/></td>
        </tr>
        <tr>
            <th>入职时间</th>
            <td><input type="text" name="hiredate" value="2015-5-11"/></td>
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
