package cn.xyh.f_ognl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * ValueStack,值栈对象
 * 值栈对象是整个Struts数据存储的核心
 * 用户每次访问Struts的action时都会创建
 * 一个Action对象、值栈对象、ActionContext对象
 * 然后把action对象放入值栈中。
 * 最后把值栈对象放入request中(key = struts.valueStack) 并传入jsp页面
 * 开发中通过ActionContext对象可以访问其他struts的对象
 */
public class OgnlDemo2 extends ActionSupport {
    // 存入根元素值，方式一：实例变量
    private User user = new User(100, "jack");

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
        ActionContext ac = ActionContext.getContext();
        // 映射数据：非根元素
        ac.getContextMap().put("request_data", "request_data");
        ac.getSession().put("session_data", "session_data");
        ac.getApplication().put("application_data", "application_data");

        // ValueStack vs = ac.getValueStack();
        // 存入根元素值，方式二：push方法
        // vs.push(new User(1002, "Tom2"));
        // 存入根元素值，方式三：set方法
        // vs.set("user3", new User(1003, "Tom3"));
        return super.execute();
    }

    /**
     * 获取值栈对象ValueStack的两种方式
     */
    private void getValueStack() {
        // 获取值栈对象ValueStack，方式一
        HttpServletRequest request = ServletActionContext.getRequest();
        ValueStack vs1 = (ValueStack) request.getAttribute("struts.valueStack");

        // 获取值栈对象ValueStack，方式二
        ActionContext ac = ActionContext.getContext();
        ValueStack vs2 = ac.getValueStack();

        System.out.println(vs1 == vs2); // true
    }
}
