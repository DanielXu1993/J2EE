package cn.xyh.c_type;

import org.apache.struts2.util.StrutsTypeConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 自定义类型转换器类
 */
public class MyConverter extends StrutsTypeConverter {
    // 支持多种格式转换
    DateFormat[] df = {
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyyMMdd"),
            new SimpleDateFormat("yyyy年MM月dd日")
    };

    /**
     * 把String转换成指定类型 【String --> Data】
     *
     * @param context 当前的上下文环境
     * @param values  jsp表单提交的字符串值
     * @param toClass 要转换的目标类型
     *                <p>
     *                1.写转换器类
     *                2.配置转换器类
     *                在src下新建一个properties文件
     *                命名规则：xwork-conversion.properties
     *                内容：java.util.Data=转换器类路径
     */
    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {

        if (values == null || values.length == 0) {
            return null;
        }
        if (Date.class != toClass) {
            return null;
        }
        for (int i = 0; i < df.length; i++) {
            try {
                return df[i].parse(values[0]);
            } catch (ParseException e) {
                continue;
            }
        }
        return null;
    }

    @Override
    public String convertToString(Map context, Object o) {
        return null;
    }
}
