<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fileUpload</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/fileUploadAction" method="post" enctype="multipart/form-data">
    用户名：<input type="text" userName="userName"><br/>
    文件:<input type="file" userName="file1"><br/>

    <input type="submit" value="上传">

</form>
</body>
</html>
