package cn10.xyh.SessionAndCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie: 用于存储会话数据，会话数据保存在浏览器客户端
 */

/**
 * Cookie类：用于存储会话数据。Cookie数据类型只能保存非中文字符串类型的。
 * <p>
 * 1）构造Cookie对象
 * Cookie(String name,String value)
 * 2）设置cookie
 * void setPath(String uri)   ：设置cookie的有效访问路径
 * void setMaxAge(int expiry) ： 设置cookie的有效时间
 * void setValue(String newValue) ：设置cookie的值
 * 3）发送cookie到浏览器端保存
 * void response.addCookie(Cookie cookie)  : 发送cookie
 * 4）服务器接收cookie
 * Cookie[] request.getCookies()  : 接收cookie
 * <p>
 * Cookie的局限：
 * 1）Cookie只能存字符串类型。不能保存对象
 * 2）只能存非中文。
 * 3）1个Cookie的容量不超过4KB。
 */
@WebServlet(name = "cookieDemo1", urlPatterns = "/cookieDemo1")
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        Cookie cookie1 = new Cookie("name", "jack");// 如果name相同，值会被覆盖
        Cookie cookie2 = new Cookie("email", "123@qq.com");

        // 发送Cookie
        response.addCookie(cookie1);
        response.addCookie(cookie2);// 可以添加多个Cookie

        // 接收Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + "=" + cookie.getValue());
            }
        } else {
            System.out.println("没有Cookie");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        this.doPost(request, response);
    }
}
