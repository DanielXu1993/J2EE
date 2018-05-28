<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp:include标签</title>
</head>
<body>
<div>
    <jsp:include page="/header.jsp"></jsp:include>
    <%--<jsp:param name="" value=""></jsp:param>--%>
    <%--
        该标签与include指令的区别：
            标签(动态包含)：
                两个页面先翻译成java源文件，然后运行时合并在一起
                包含页面可以向被包含页面传递参数
            指令(静态包含)：
                现将两个页面合并再翻译成一个java源文件
                包含页面不可以向被包含页面
    --%>
</div>
主页的内容
</body>
</html>
