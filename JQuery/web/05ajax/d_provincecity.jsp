<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省份-城市,基于jQuery的AJAX二级联动</title>
    <script src="../js/jquery.js"></script>
</head>
<body>
<select id="province">
    <option>选择省份</option>
    <option>湖南</option>
    <option>广东</option>
</select>
<select id="city">
    <option>选择城市</option>
</select>
</body>
<script>
    $("#province").change(function () {
        $("#city option:gt(0)").remove();
        if ($("#province option:selected").text() != "选择省份") {
            $.ajax({
                url: "${pageContext.request.contextPath}/struts2/findCityByProvinceRequest",
                data: {"province": $("#province option:selected").text()},
                success: function (msg) {
                    var cityArray = msg.citySet;
                    $(cityArray).each(function (index) {
                        var city = cityArray[index];
                        $("#city").append("<option>" + city + "</option>");
                    });
                }
            });
        }
    });
</script>
</html>
