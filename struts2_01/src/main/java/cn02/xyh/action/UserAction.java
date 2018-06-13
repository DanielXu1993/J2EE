package cn02.xyh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * ParametersInterceptor拦截器会对请求的参数进行封装，请求的参数的name属性必须与
 * action中的实例变量名对应，并且action中需要提供set方法。如果多个参数封装在一个对象中，这个
 * 对象应该是action的一个实例变量并且有set方法，参数的name属性应该是  对象名.参数名  的格式，
 * 否则会产生NullPointerException
 */
public class UserAction extends ActionSupport {
    //private String userName;
    //private String pwd;
    //
    //public void setPwd(String pwd) {
    //    this.pwd = pwd;
    //}
    //
    //public void setUserName(String userName) {
    //    this.userName = userName;
    //}
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String login() {
        System.out.println(user.getUserName());
        System.out.println(user.getPwd());

        ActionContext ac = ActionContext.getContext();
        Map<String, Object> request = ac.getContextMap();
        Map<String, Object> session = ac.getSession();
        Map<String, Object> application = ac.getApplication();

        request.put("request_data","request_data");
        session.put("session_data","session_data");
        application.put("application_data","application_data");
        return "login";
    }
}
