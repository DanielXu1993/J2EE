<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <%--
            JSP的九大內置对象：
            内置对象名               类型
            request	            HttpServletRequest
            response            HttpServletResponse
            config              ServletConfig
            application         ServletContext
            session             HttpSession
            exception           Throwable
            page                Object(当前页面的源文件this)
            out                 JspWriter
            pageContext         PageContext

    --%>

    <%--
        out 对象，相当于带缓冲的PrintWriter
        PrintWriter：
			    wrier(内容)： 直接向浏览器写出内容。
        JspWriter
				writer(内容): 向jsp缓冲区写出内容
                当满足以下条件之一，缓冲区内容写出：
						1）缓冲区满了
						2）刷新缓存区
						3）关闭缓存区
						4）执行完毕jsp页面
    --%>
    <%--
        pageContext对象的类型是PageContext，叫jsp的上下文对象
         1）可以获取其他八个内置对象
         2）本身是一个域对象
         page域： 只能在当前jsp页面中使用（当前页面）
		 request域： 只能在同一个请求中使用（转发）
		 session域： 只能在同一个会话（session对象）中使用（私有的）
		 context域： 只能在同一个web应用中使用。（全局的）
    --%>
</div>
</body>
</html>
