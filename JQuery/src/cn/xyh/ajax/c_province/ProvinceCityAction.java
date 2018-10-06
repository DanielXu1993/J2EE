package cn.xyh.ajax.c_province;

import com.opensymphony.xwork2.ActionSupport;

import java.util.LinkedHashSet;
import java.util.Set;

public class ProvinceCityAction extends ActionSupport {
    private String province;

    public void setProvince(String province) {
        this.province = province;
    }

    public String findCityByProvince() {

        citySet = new LinkedHashSet<>();
        if ("湖南".equals(province)) {
            citySet.add("长沙");
            citySet.add("株洲");
        } else if ("广东".equals(province)) {
            citySet.add("广州");
            citySet.add("中山");
            citySet.add("佛山");
        }
        return SUCCESS;
    }

    private Set<String> citySet;

    public Set<String> getCitySet() {
        return citySet;
    }
}
