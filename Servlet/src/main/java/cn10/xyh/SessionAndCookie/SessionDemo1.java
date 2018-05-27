package cn10.xyh.SessionAndCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Session特点：会话数据保存在服务器端。
 * <p>
 * HttpSession类：用于保存会话数据
 * 1）创建或得到session对象
 * HttpSession getSession()
 * HttpSession getSession(boolean create)
 * 2）设置session对象
 * void setMaxInactiveInterval(int interval)  ： 设置session的有效时间(单位秒)
 * void invalidate()     ： 销毁session对象
 * String getId()  ： 得到session编号
 * 3）保存会话数据到session对象
 * void setAttribute(String name, Object value)  ： 保存数据
 * Object getAttribute(String name)  ： 获取数据
 * void removeAttribute(String name) ： 清除数据
 */
@WebServlet(name = "sessionDemo1", urlPatterns = "/sessionDemo1")
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        this.doPost(request, response);
    }
}
