<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jQuery解析XML</title>
    <script src="../js/jquery.js"></script>
</head>
<body>
<input type="button" value="解析服务器相应的XML文件"/>
</body>
<script>
    $(":button").click(function () {
        var url = "${pageContext.request.contextPath}/05ajax/c_city.xml?time=" + new Date().getTime();
        var sendData = null;
        $.ajax({
            url: url,
            data: sendData,
            success: function (xml) {
                var $xml = $(xml).find("city");
                $xml.each(function () {
                    alert($(this).text());
                });
            }
        });
    });
</script>
</html>
