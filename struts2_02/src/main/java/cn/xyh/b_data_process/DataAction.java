package cn.xyh.b_data_process;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class DataAction extends ActionSupport {

    @Override
    public String execute() throws Exception {

        // struts中对数据操作，方式1：直接拿到servlet API
        //HttpServletRequest request = ServletActionContext.getRequest();
        //HttpSession session = request.getSession();
        //ServletContext application = ServletActionContext.getServletContext();

        //request.setAttribute("request_data","request_data");
        //session.setAttribute("session_data","session_data");
        //application.setAttribute("app_data","app_data");


        // struts中对数据操作，方式2:通过ActionContext类
        ActionContext ac = ActionContext.getContext();
        // 拿到表示request对象的map
        Map<String, Object> request = ac.getContextMap();

        // 拿到表示session对象的map
        Map<String, Object> session = ac.getSession();

        // 拿到表示servletContext对象的map
        Map<String, Object> application = ac.getApplication();

        request.put("request_data", "request_data");
        session.put("session_data", "session_data");
        application.put("app_data", "app_data");

        return SUCCESS;
    }
}
