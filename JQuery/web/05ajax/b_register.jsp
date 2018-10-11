<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <script src="../js/jquery.js"></script>
</head>
<body>
<form>
    <table border="2" align="center">
        <tr>
            <th>用户名</th>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <th>密码</th>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="button" value="检查" style="width:111px"/></td>
        </tr>
    </table>
</form>
<span></span>
<script>
    $(":button").click(function () {
        var username = $(":text").val();
        var password = $(":password").val();
        var url = "${pageContext.request.contextPath}/userServlet?time=" + new Date().getTime();
        // var sendData = {
        //     "username": username,
        //     "password": password
        // };
        var sendData = $("form").serialize();// 将form标签中含有name属性的值封装成json格式的对象
        $.post(url, sendData, function (backData) {
            // backData:如果服务器返回的是html或者字符串,则不需要进行解析
            var $img = $("<img src='../" + backData + "' width='14px' height='14px' />");
            $("span").text("");
            $("span").append($img);
        });
    });
</script>
</body>
</html>
