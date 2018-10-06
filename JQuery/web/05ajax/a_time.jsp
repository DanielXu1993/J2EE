<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>取得服务端当前时间</title>
    <script src="../js/jquery.js"></script>
</head>
<body>
<div>
    当前时间:<span id="time"></span><br/>
    <input type="button" value="获取时间">
</div>
</body>
<script type="text/javascript">
    $(":button").click(function () {
        // 1.发送请求路径
        var url = "${pageContext.request.contextPath}/timeServlet?time=" + new Date().getTime();
        // 2.发送的参数,以JSON格式书写
        var sendData = {
            "name": "哈哈",
            "sal": 10000
        };
        $("#time").load(url, sendData, function (backData, textStatus, xmlHttpRequest) {
            // 回调函数的参数:
            /**
             * 1.backData:表示返回的数据,它是一个js对象
             * 2.textStatus:表示返回状态的文本,例如success,error等
             * 3.xmlHttpRequest:表示ajax的核心对象xmlHttpRequest
             * 项目中通常是需要使用backData对象
             */
            $("#time").text(backData.date);
        });
    });
</script>
</html>
