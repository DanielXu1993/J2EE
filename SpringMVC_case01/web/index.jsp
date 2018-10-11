<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>员工管理系统</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/add.action" method="post">
  <table border="2" align="center">
    <tr>
      <th>姓名</th>
      <%--name中的属性必须与pojo中的属性保持一致--%>
      <td>
        <input type="text" name="username"/>
      </td>
    </tr>
    <tr>
      <th>薪水</th>
      <td><input type="text" name="salary" value="7000"/>
      </td>
    </tr>
    <tr>
      <th>入职时间</th>
      <td>
        <input type="text" name="hiredate" value="2015-5-10"/>
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center"><input type="submit" value="提交"></td>
    </tr>
  </table>
</form>
</body>
</html>
