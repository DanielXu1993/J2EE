package cn.xyh.f_ognl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OgnlDemo3 extends ActionSupport {
    @Override
    public String execute() throws Exception {
        // 测试迭代标签

        List<User> list = new ArrayList<>();
        Map<Integer, User> map = new HashMap<>();
        // 构建数据
        for (int i = 1; i < 11; i++) {
            User user = new User(i, "Jack" + i);
            list.add(user);
            map.put(i, user);
        }
        // 保存数据
        ActionContext.getContext().getContextMap().put("list", list);
        ActionContext.getContext().getContextMap().put("map", map);

        return super.execute();
    }
}
