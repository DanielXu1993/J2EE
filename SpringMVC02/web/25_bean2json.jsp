<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="js/jquery.js"></script>
</head>
<body>
<input type="button" value="Emp转JSON">
<p>
    <input type="button" value="List<Emp>转JSON">
<p>
    <input type="button" value="Map<String,Object>转JSON">
<p>

</body>
<script>
    $(":button:first").click(function () {
        $.ajax({
            method: "post",
            data: null,
            url: "${pageContext.request.contextPath}/emp/bean2json.action",
            success: function (msg) {
                alert(msg.id + "-->" + msg.username + "-->" + msg.salary + "-->" + new Date(msg.hiredate).toDateString());
            }
        });
    });

    $(":button:eq(1)").click(function () {
        $.ajax({
            method: "post",
            data: null,
            url: "${pageContext.request.contextPath}/emp/listbean2json.action",
            success: function (msg) {
                alert(msg);
            }
        });
    });


    $(":button:last").click(function () {
        $.ajax({
            method: "post",
            data: null,
            url: "${pageContext.request.contextPath}/emp/map2json.action",
            success: function (msg) {
                alert(msg);
            }
        });
    });
</script>
</html>
